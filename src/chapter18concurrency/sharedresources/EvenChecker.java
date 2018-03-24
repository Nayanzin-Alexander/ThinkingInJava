package chapter18concurrency.sharedresources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.09.17.
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    // Constructor
    public EvenChecker(IntGenerator g, int ident) {
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while(!generator.isCanceled()) {
            int val = generator.next();
            if(val % 2 != 0) {
                print(val + " is not even");
                generator.cancel(); // Cancels all EvenCheckers
            }
            if(val > 100000) {
                print("Value reached 100000");
                generator.cancel();
            }

        }
    }


    // Test any type of IntGenerator:
    public static void test(IntGenerator gp, int count) {
        print("Press cntrl+c to exit");
        ExecutorService exec = Executors.newCachedThreadPool();

        for(int i = 0; i < count; i++)
            exec.execute(new EvenChecker(gp, i));
        exec.shutdown();
    }

    // Default value for count:
    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
