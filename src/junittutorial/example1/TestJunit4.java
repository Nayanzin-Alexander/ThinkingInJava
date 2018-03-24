package junittutorial.example1;

import junit.framework.TestCase;
import org.junit.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.08.17.
 */
public class TestJunit4 extends TestCase {
    protected double fValue1;
    protected double fValue2;

    @Before
    @Override
    public void setUp() {
        fValue1 = 2.0;
        fValue2 = 3.0;
    }

    @Test
    public void testAdd() {
        // count the number of test cases
        print("Number of test cases is: " + this.countTestCases());

        // test get name
        this.setName("Added name testNewAdd");
        String newName = this.getName();
        print(this.getName());
    }

    // tearDown used to close the connection or clean up activities
    @Override
    public void tearDown(){
        print("tearDown method invocation");
    }

}
