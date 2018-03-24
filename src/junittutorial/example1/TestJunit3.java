package junittutorial.example1;

import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by nayanzin on 25.08.17.
 */
public class TestJunit3 {

    @Test
    public void testAdd() {
        // test data
        int num = 5;
        String temp = null;
        String str = "Junit is working fine";

        // check for equality
        assertEquals("Junit is working fine", str);

        // check for false condition
        assertFalse(num > 6);

        //check for not null value
        assertNotNull(str);


    }
}
