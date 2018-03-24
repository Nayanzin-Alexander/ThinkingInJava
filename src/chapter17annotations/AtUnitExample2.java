package chapter17annotations;

import unittest.AtUnit;
import unittest.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 24.08.17.
 */
public class AtUnitExample2 {
    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        print("This is methodTwo");
        return 2;
    }

    @Test
    void assertExample() {
        assert methodOne().equals("This is methodOne");
    }

    @Test void assertFailureExample() {
        assert 1 == 2: "What a surprisr!";
    }

    @Test void exceptionExample() throws IOException {
        new FileInputStream("nofile2.txt"); // Throws
    }

    @Test boolean assertAndReturn() {
        // Assertion with message:
        assert methodTwo() == 2: "methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }

    public static void main(String... args) {
        AtUnit.runTest("chapter17annotations/AtUnitExample2");
    }

}
