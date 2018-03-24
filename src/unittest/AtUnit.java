package unittest;

import myutil.standartio.OSExecute;
import unittest.Test;
import myutil.BinaryFile;
import myutil.ProcessFiles;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;
import static myutil.envoronment.getClassPath;
import static myutil.envoronment.getProjectDir;

/**
 * Created by nayanzin on 20.08.17.
 */
public class AtUnit implements ProcessFiles.Strategy{
    static Class<?> testClass;
    static List<String> failedTests = new ArrayList<>();
    static long testsRun = 0;
    static long failures = 0;

    public static void runTest(String arg){
        String command1 = "java "+
                getClassPath() + " " +
                "unittest.AtUnit " +
                getProjectDir() + arg;
        OSExecute.command(command1);
    }

    // Entry point to the program
    public static void main(String... args) throws Exception {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true); // Enable asserts

        new ProcessFiles(new AtUnit(), "class").start(args);
        if(failures == 0)
            print("OK (" + testsRun + ") tests");
        else {
            print("(" + testsRun + " tests)");
            print("\n>>> " + failures + " FAILURE" +
                    (failures > 1 ? "S" : "") + " <<<");
            for(String failed : failedTests)
                print(" " + failed);
        }
    }

    @Override
    public void process(File cFile) {
        try {
            String cName = ClassNameFinder.thisClass(BinaryFile.readBinaryFile(cFile.getAbsoluteFile().toString()));
            if(!cName.contains("."))
                return; // Ignore unpackaged classes
            testClass = Class.forName(cName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        TestMethods testMethods = new TestMethods();
        Method creator = null;
        Method cleanup = null;
        for(Method m : testClass.getDeclaredMethods()) {
            testMethods.addIfTestMethod(m);
            if(creator == null)
                creator = checkForCreatoerMethod(m);
            if(cleanup == null)
                cleanup = checkForCleanUpMethod(m);
        }

        if(testMethods.size() > 0) {
            if(creator == null)
                try {
                    if(!Modifier.isPublic(
                            testClass.getDeclaredConstructor().getModifiers())) {
                        print("Error: " + testClass + "default constructor must be public");
                        System.exit(-1);
                    }
                } catch(NoSuchMethodException e) {
                    // Synthesized default constructor; OK
                }
            print(testClass.getName());
        }
        for(Method m :testMethods) {
            printInLine("   . " + m.getName() + " ");
            try {
                Object testObject = createTestObject(creator);
                boolean success = false;
                try {
                    if(m.getReturnType().equals((boolean.class)))
                        success = (Boolean) m.invoke(testObject);
                    else {
                        m.invoke(testObject);
                        success = true; // if no asserts fails
                    }
                } catch(IllegalAccessException e) {
                    print(e);
                } catch (InvocationTargetException e) {
                    // Actual exception is inside e:
                    print(e.getCause());
                }
                print(success ? "" : "(failed)");
                testsRun++;
                if(!success) {
                    failures++;
                    failedTests.add(testClass.getName() + " : " + m.getName());
                }
                if(cleanup != null)
                    cleanup.invoke(testObject, testObject);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class TestMethods extends ArrayList<Method> {
        void addIfTestMethod(Method m) {
            if(m.getAnnotation(Test.class) == null)
                return;
            if(!(m.getReturnType().equals(boolean.class) ||
                    m.getReturnType().equals(void.class)))
                throw new RuntimeException("@TestJunit1 method " + m + " must return boolean or void");
            m.setAccessible(true); // In case it's private
            add(m);
        }
    }

    private static Method checkForCreatoerMethod(Method m) {
        if(m.getAnnotation(TestObjectCreate.class) == null)
            return null;

        if(!m.getReturnType().equals(testClass))
            throw new RuntimeException("@TestObjectCreate must return instatnce of Class to be tested");

        if((m.getModifiers() & Modifier.STATIC) < 1)
            throw new RuntimeException("@TestObjectCreate must be static");

        m.setAccessible(true);
        return m;
    }

    private static Method checkForCleanUpMethod(Method m) {
        if(m.getAnnotation(TestObjectCleanup.class) == null)
            return null;

        if(!m.getReturnType().equals(void.class))
            throw new RuntimeException("@TestObjectCleanup must return void");

        if((m.getModifiers() & Modifier.STATIC) < 1)
            throw new RuntimeException("@TestObjectCleanup must be static");

        if(m.getParameterTypes().length == 0 ||
                m.getParameterTypes()[0] != testClass)
            throw new RuntimeException("@TestObjectCleanup must take an argument of the tested type");

        m.setAccessible(true);
        return m;
    }

    private static Object createTestObject(Method creator) {
        if(creator != null) {
            try {
                return creator.invoke(testClass);
            } catch (Exception e) {
                throw new RuntimeException("Couldn't run @TestObject (creator) method " + e);
            }
        } else { // Use default constructor:
            try{
                return testClass.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Couldn't create a test object. Try using a @TestObject method.");
            }
        }
    }
}
