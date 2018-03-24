package chapter11typeinformation;

import java.util.HashMap;

import static myutil.ClassInfo.printClass;

/**
 * Created by nayanzin on 10.07.17.
 */
public class TestClass {
    public static void main(String... args) throws ClassNotFoundException {
        //Class hashMapClass = Class.forName("java.util.HashMap");
        Class hashMapClass = HashMap.class;
        printClass(TestClass.class);
        printClass(int.class);
    }
}
