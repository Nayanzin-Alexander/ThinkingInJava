package chapter18concurrency.sharedresources;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.09.17.
 */
public class AttempingLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            print("tryLock(): " + captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            print("tryLock(): " + captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }

    public static void main(String... args) {
        final AttempingLocking al = new AttempingLocking();
        al.untimed();
        al.timed();

        // Now create a separate task to grab the lock:
        Thread t = new Thread(()->{
           al.lock.lock();
           print("Acquired");
        });
        t.setDaemon(true);
        t.start();

        Thread.yield();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            print("Interrupted main");
        }
        al.untimed();
        al.timed();
    }
}
