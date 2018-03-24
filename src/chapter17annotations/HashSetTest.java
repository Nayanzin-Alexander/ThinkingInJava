package chapter17annotations;

import unittest.AtUnit;
import unittest.Test;

import java.util.HashSet;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 24.08.17.
 */
public class HashSetTest {

    class TestHashSet<T> extends HashSet<T> {
        public TestHashSet() {
            super();
            print("Object creation");
        }
    }

    HashSet<String> testObject = new TestHashSet<>();

    @Test void initialization() {
        assert testObject.isEmpty();
    }

    @Test void _contains() {
        testObject.add("one");
        assert testObject.contains("one");
    }

    @Test void remove() {
        testObject.add("one");
        testObject.remove("one");
        assert !testObject.contains("one");
    }

    public static void main(String... args) {
        AtUnit.runTest("chapter17annotations/HashSetTest");
    }
}
