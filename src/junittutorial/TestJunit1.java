package junittutorial;

import org.junit.Test;
import sun.misc.MessageUtils;

import static junit.framework.TestCase.assertEquals;
import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.08.17.
 */
public class TestJunit1 {
    String message = "Robert";

    @Test
    public void testPrintMessage() {
        print("Inside testPrintMessage()");
        assertEquals("Robert", message);
    }
}
