package chapter14containersindepth.perfomancetestframework;

import chapter14containersindepth.hashcode.MapEntry;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;

/**
 * Created by nayanzin on 31.07.17.
 */
public class LambdaTester <C> {

    // Testing
    public static TestParam[] defaultParams = TestParam.array(
            10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    protected C container;
    private Map<String, Testable<C>> tests;
    private TestParam[] paramList = defaultParams;

    // Constructors
    public LambdaTester(C container, Map<String, Testable<C>> tests){
        this.container = container;
        this.tests = tests;
        if(container != null)
            headline = container.getClass().getSimpleName();
    }

    public LambdaTester(C container, Map<String, Testable<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    // Methods:
    // Override this to modify pre-test initialization:
    protected C initialize(int size) {
        return container;
    }

    // Generic methods for convenience :
    public static <C> void run(C cntr, Map<String, Testable<C>> tests) {
        new LambdaTester<C> (cntr, tests).timedTest();
    }

    public static <C> void run(C cntnr, Map<String, Testable<C>> tests, TestParam[] paramList) {
        new LambdaTester<C>(cntnr, tests, paramList).timedTest();
    }

    // Run the tests for this container:
    public void timedTest() {
        displayHeader();
        for(TestParam param : paramList) {
            printInLine(String.format(sizeField, param.size));
            for(Map.Entry<String, Testable<C>> test : tests.entrySet()) {
                C container = initialize(param.size);

                long start = System.nanoTime();
                // Call the overriden method:
                int reps = test.getValue().test(container, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps; // Nanoseconds

                printInLine(String.format(numberedField(), timePerRep));
            }
            print();
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
        for(Map.Entry<String, Testable<C>> test : tests.entrySet())
            printInLine(String.format(stringField(), test.getKey()));
        print();
    }
}
