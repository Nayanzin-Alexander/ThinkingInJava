package junittutorial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nayanzin on 24.08.17.
 */
public class TestJunit {
    @Test
    public void testAdd() {
        String str = "Junit working fine";
        assertEquals("Junit working fine", str);
    }
}
