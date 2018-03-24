package junittutorial.example1;

import unittest.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nayanzin on 25.08.17.
 */
public class TestJunit2 {
    String message = "Hello world";

    MessageUtil messageUtil = new MessageUtil(message);

    @org.junit.Test
    public void testPrintMessage() {
        assertEquals(message, messageUtil.printMessage());
    }
}
