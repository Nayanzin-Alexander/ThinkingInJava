package chapter18concurrency;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 31.08.17.
 */

class TaskWithResult implements Callable<String> {
    private static long count = 0;
    public final long ID = ++count;

    @Override
    public String call() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000 * ID);
        } catch (InterruptedException e) {
            print("Interrupted");
        }
        return "TaskWithResult ID: " + ID;
    }
}
public class CallableDemo {
    public static void main(String... args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            results.add(exec.submit(new TaskWithResult()));
        }
        for(Future<String> result : results) {
            try{
                print(result.get());
            } catch (InterruptedException e) {
                print("Interrupted exception caught");
            } catch (ExecutionException e) {
                print("Execution exception caught");
            } finally {
                exec.shutdown();
            }
        }

        print("All results are printed");
    }
}
