package chapter18concurrency.sharedresources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.09.17.
 */
public class ex1 {
    private static  int  counter = 0;
    private static Runnable task = ()->{
        for(int i = 0; i < 10000; i++)
            counter++;
    };

    public static void main(String... args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(task);
        exec.execute(task);

        TimeUnit.MILLISECONDS.sleep(10000);
        print(counter);
        counter = 0;

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        TimeUnit.MILLISECONDS.sleep(10000);
        print(counter);
    }
}
