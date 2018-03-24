package chapter18concurrency;

import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 31.08.17.
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d; // No optimizaton
    private int priority;

    // Constructor
    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true) {
            // An expensive, interruptable operation:
            for(int i = 1; i < 10000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if( i % 1000 == 0)
                    Thread.yield();
            }
            print(Thread.currentThread().getPriority());
            if(--countDown == 0) return;
        }
    }

    public static void main(String... args) {
        ExecutorService exec = Executors.newFixedThreadPool(16);
        for(int i = 0; i < 6; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
            exec.execute(new SimplePriorities(Thread.NORM_PRIORITY));
            exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
            exec.shutdownNow();
        }

    }
}
