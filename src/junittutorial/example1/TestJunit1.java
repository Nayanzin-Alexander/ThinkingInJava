package junittutorial.example1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by nayanzin on 25.08.17.
 */
public class TestJunit1 {
    String message = "Hello world";

    MessageUtil messageUtil = new MessageUtil(message);

   @Test
    public void testPrintMessage() {
        assertEquals(message, messageUtil.printMessage());
    }
}
