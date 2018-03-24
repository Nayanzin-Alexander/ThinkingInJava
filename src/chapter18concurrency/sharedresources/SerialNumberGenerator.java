package chapter18concurrency.sharedresources;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nayanzin on 01.09.17.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    private static ReentrantLock lock = new ReentrantLock();
    public static int nextSerialNumber() {
        lock.lock();
        try {
            return serialNumber++; // Not thread-safe
        } finally {
            lock.unlock();
        }
    }
}
