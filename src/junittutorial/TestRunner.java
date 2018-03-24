package junittutorial;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.08.17.
 */
public class TestRunner {
    public static void main(String... args) {
        Result result = JUnitCore.runClasses(TestJunit.class);
        for (Failure failure : result.getFailures()) {
            print(failure);
        }
        print("Result was successful: " + result.wasSuccessful());
    }
}
