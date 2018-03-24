package junittutorial;

import junit.framework.TestCase;

/**
 * Created by nayanzin on 25.08.17.
 */
public class JavaTest extends TestCase {
    protected int value1, value2;

    // assigning the values

    protected void setUp() {
        value1 = 3;
        value2 = 3;
    }

    // test method to add two values
    public void testAdd() {
        double result = value1 + value2;
        assertTrue(result == 6);
    }
}
