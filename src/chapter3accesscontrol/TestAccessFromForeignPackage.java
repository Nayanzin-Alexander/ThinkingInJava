package chapter3accesscontrol;

import myutil.AccessTest;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 26.06.17.
 */
public class TestAccessFromForeignPackage {
    public static void main(String... args){
        print("===Testing access specifiers without inheritance inside the same package");

        print("=Testing access static fields");
        print(AccessTest.publicStatic);
        print("unable to call packageStatic... because it has package access specifier, " +
                "and called from another package");
        print("unable to call protectedStatic... because it has protected access specifier, " +
                "and called from another package");
        print("unable to call privateStatic... because it has private access specifier");

        print("=Testing access non static fields");
        AccessTest accessTest = new AccessTest();
        print(accessTest.publicStr);
        print("unable to call packageStr... because it has package access specifier, " +
                "and called from another package");
        print("unable to call protectedStr... because it has protected access specifier, " +
                "and called from another package");
        print("unable to call privateStr... because it has private access specifier");

        print("=Testing  access to static methods");
        AccessTest.doPublicStatic();
        print("unable to call doPackageStatic... because it has package access specifier, " +
                "and called from another package");
        print("unable to call doProtectedStatic... because it has protected access specifier, " +
                "and called from another package");
        print("unable to call doPrivateStatic... because it has private access specifier");

        print("=Testing access non static methods");
        AccessTest accessTest2 = new AccessTest();
        accessTest2.doPublic();
        print("unable to call doPackage... because it has package access specifier, " +
                "and called from another package");
        print("unable to call doProteected... because it has protected access specifier, " +
                "and called from another package");
        print("unable to call doPrivate... because it has private access specifier");

        print("===Resume: We have access only to public methods and fields, " +
                "trying to use class from foreign package");
    }
}
