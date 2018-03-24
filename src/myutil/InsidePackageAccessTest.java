package myutil;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 26.06.17.
 */
public class InsidePackageAccessTest {
    public static void main(String... args){
        print("===Testing access specifiers without inheritance inside the same package");

        print("=Testing access static fields");
        print(AccessTest.publicStatic);
        print(AccessTest.packageStatic);
        print(AccessTest.protectedStatic);
        print("unable to call privateStatic... because it has private access specifier");

        print("=Testing access non static fields");
        AccessTest accessTest = new AccessTest();
        print(accessTest.publicStr);
        print(accessTest.packageStr);
        print(accessTest.protectedStr);
        print("unable to call privateStr... because it has private access specifier");

        print("=Testing  access to static methods");
        AccessTest.doPublicStatic();
        AccessTest.doPackageStatic();
        AccessTest.doProtectedStatic();
        print("unable to call doPrivateStatic... because it has private access specifier");

        print("=Testing access non static methods");
        AccessTest accessTest2 = new AccessTest();
        accessTest2.doPublic();
        accessTest2.doPackage();
        accessTest2.doProtected();
        print("unable to call doPrivate... because it has private access specifier");

        print("===Resume: We have access to public, package, protected methods and fields, " +
                "trying to use class from local package");
    }
}
