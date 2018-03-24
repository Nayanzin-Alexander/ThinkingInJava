package chapter14containersindepth.perfomancetestframework;

import java.util.List;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;

/**
 * Created by nayanzin on 31.07.17.
 */
public class Tester <C> {

    // Testing
    public static TestParam[] defaultParams = TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    protected C container;
    private List<Test<C>> tests;
    private TestParam[] paramList = defaultParams;

    // Constructors
    public Tester(C container, List<Test<C>> tests){
        this.container = container;
        this.tests = tests;
        if(container != null)
            headline = container.getClass().getSimpleName();
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    // Methods:
    // Override this to modify pre-test initialization:
    protected C initialize(int size) {
        return container;
    }

    // Generic methods for convenience :
    public static <C> void run(C cntr, List<Test<C>> tests) {
        new Tester<C> (cntr, tests).timedTest();
    }

    public static <C> void run(C cntnr, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(cntnr, tests, paramList).timedTest();
    }

    // Run the tests for this container:
    public void timedTest() {
        displayHeader();
        for(TestParam param : paramList) {
            print(String.format(sizeField, param.size));
            for(Test<C> test : tests){
                C container = initialize(param.size);
                long start = System.nanoTime();
                // Call the overriden method:
                int reps = test.test(container, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps; // Nanoseconds
                printInLine(String.format(numberedField(), timePerRep));
            }
        }
    }

    // Formatting output:
    public static int fieldWidth = 8;
    private String headline = "";
    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";

    // Methods
    private static String stringField() {
        return "%" + fieldWidth + "s";
    }
    private static String numberedField() {
        return "%" + fieldWidth + "d";
    }

    public void setHeadline(String newHeadline) {
        headline = newHeadline;
    }

    private void displayHeader() {
        // Calculate width and pad with '-':
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() -1;
        StringBuilder head = new StringBuilder(width);
        for(int i = 0; i < dashLength/2; i++)
            head.append('-');
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for(int i=0; i< dashLength/2; i++)
            head.append('-');
        print();
        print(head);
        print();
        // Print column headers:
        printInLine(String.format(sizeField, "size"));
        for(Test test : tests)
            printInLine(String.format(stringField(), test.name));
        print();
    }
}
