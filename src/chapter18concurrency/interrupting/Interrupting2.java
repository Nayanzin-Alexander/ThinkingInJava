package chapter18concurrency.interrupting;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 06.09.17.
 */

class BlockedMutex {
    private Lock lock = new ReentrantLock();
    // Constructor
    public BlockedMutex() {
        // Acquire it right away, to demonstrate interruption
        // of a task blocked on a ReentrantLock:
        lock.lock();
    }

    public void f() {
        try {
            // This will never be available to a second task
            lock.lockInterruptibly(); // Special call
            print("Lock acquired");
        } catch (InterruptedException e) {
            print("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();

    @Override
    public void run() {
        print("Waiting for f() in BlockedMutex");
        blocked.f();
        print("Broken getStr of blocked call");
    }
}

public class Interrupting2 {
    public static void main(String... args) throws Exception {
        Thread t = new Thread(new Blocked2());
        t.start();

        TimeUnit.SECONDS.sleep(1);
        print("Issuing t.interrupt");
        t.interrupt();
    }
}
