package junittutorial;

import junit.framework.TestCase;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.08.17.
 */
public class TestJunit2 extends TestCase{
    String message;
    protected void setUp() {
        message = "Robert";
    }

    public void testSalutationMethod() {
        print("Inside testSalutationMethod()");
        assertEquals("Robert", message);
    }
}
