package chapter18concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 31.08.17.
 */
public class DaemonFromFactory implements Runnable {
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            print(Thread.currentThread() + " " + this);
        } catch (InterruptedException e) {
            print("interrupted");
        }
    }

    public static void main(String... args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        print("All daemons are started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
