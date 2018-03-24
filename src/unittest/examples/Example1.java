package unittest.examples;

import myutil.standartio.OSExecute;
import unittest.*;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;
import static myutil.envoronment.getClassPath;
import static myutil.envoronment.getProjectDir;

/**
 * Created by nayanzin on 22.08.17.
 */
public class Example1 {
    public String methodOne(){
        return "This is method one";
    }

    public int methodTwo(){
        printInLine("This is method two");
        return 2;
    }

    @Test boolean methodOneTest() {
        return methodOne().equals("This is method one");
    }

    @Test boolean m2() { return methodTwo() == 2; }

    @Test private boolean m3() { return true; }

    @Test boolean failureTest() { return false; }

    @Test boolean anotherDisaappointment() { return false; }

    public static void main(String... args) throws Exception{
        AtUnit.runTest("unittest/examples/Example1");
    }

}
