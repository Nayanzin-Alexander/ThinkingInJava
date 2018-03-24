package junittutorial.example1;

import org.junit.runner.*;
import org.junit.runners.Suite;

/**
 * Created by nayanzin on 25.08.17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestJunit1.class, TestJunit2.class,
        TestJunit3.class, TestJunit4.class
})
public class TestSuite {
}
