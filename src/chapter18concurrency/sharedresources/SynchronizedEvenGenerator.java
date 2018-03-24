package chapter18concurrency.sharedresources;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.yield;

/**
 * Created by nayanzin on 01.09.17.
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentValue = 0;
    Lock lock = new ReentrantLock();

    public int next() {
        lock.lock();
        try {
            currentValue++;
            yield();
            currentValue++;
            return currentValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String... args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
