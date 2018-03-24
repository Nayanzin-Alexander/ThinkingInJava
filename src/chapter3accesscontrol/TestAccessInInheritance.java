package chapter3accesscontrol;

import myutil.AccessTest;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 26.06.17.
 */
public class TestAccessInInheritance extends AccessTest {
    public static void main(String... args){
        print("===Testing access specifiers with inheritance from the foreign package");

        print("=Testing access static fields");
        print(TestAccessInInheritance.publicStatic);
        print("unable to call packageStatic... because it we trying to call " +
                "it from the foreign package");
        print(TestAccessInInheritance.protectedStatic);
        print("unable to call privateStatic... because it has private access specifier");

        print("=Testing access non static fields");
        TestAccessInInheritance accessTest = new TestAccessInInheritance();
        print(accessTest.publicStr);
        print("unable to call packageStr... because it we trying to call " +
                "it from the foreign package");
        print(accessTest.protectedStr);
        print("unable to call privateStr... because it has private access specifier");

        print("=Testing  access to static methods");
        TestAccessInInheritance.doPublicStatic();
        print("unable to call doPackageStatic... because it we trying to call " +
                "it from the foreign package");
        TestAccessInInheritance.doProtectedStatic();
        print("unable to call doPrivateStatic... because it has private access specifier");

        print("=Testing access non static methods");
        TestAccessInInheritance accessTest2 = new TestAccessInInheritance();
        accessTest2.doPublic();
        print("unable to call doPackage... because it we trying to call " +
                "it from the foreign package");
        accessTest2.doProtected();
        print("unable to call doPrivate... because it has private access specifier");

        print("===Resume: We have access to public, protected methods and fields, " +
                "using inheritance from the foreign package");
    }
}
