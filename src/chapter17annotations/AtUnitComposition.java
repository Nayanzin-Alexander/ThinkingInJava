package chapter17annotations;

import unittest.AtUnit;
import unittest.Test;
import unittest.examples.Example1;

/**
 * Created by nayanzin on 24.08.17.
 */
public class AtUnitComposition {
    Example1 testObject = new Example1();

    @Test
    boolean _methodOne() {
        return testObject.methodOne().equals("This is method one");
    }

    @Test boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }

    public static void main(String... args) {
        AtUnit.runTest("chapter17annotations/AtUnitComposition");
    }
}
