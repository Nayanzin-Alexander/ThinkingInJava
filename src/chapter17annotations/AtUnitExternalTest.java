package chapter17annotations;

import unittest.AtUnit;
import unittest.Test;
import unittest.examples.Example1;

/**
 * Created by nayanzin on 24.08.17.
 */
public class AtUnitExternalTest extends Example1 {
    @Test boolean _methodOne() {
        return methodOne().equals("This is method one");
    }
    @Test boolean _methodTwo() {return methodTwo() == 2; }

    public static void main(String... args) throws Exception {
        AtUnit.runTest("chapter17annotations/AtUnitExternalTest");
    }
}
