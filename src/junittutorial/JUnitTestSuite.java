package junittutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static myutil.Printer.print;
import static org.junit.Assert.assertEquals;

/**
 * Created by nayanzin on 25.08.17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestJunit1.class, TestJunit2.class
})
public class JUnitTestSuite {

    public void testSuiteMethod() {
        print("Inside testSuiteMethod");
        assertEquals("1", "1");
    }
}
