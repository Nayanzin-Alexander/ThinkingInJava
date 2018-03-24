package chapter18concurrency.sharedresources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.09.17.
 */

class Pair { // Not thread-safe
    private int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x: " + x + " , y: " + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        // Constructor
        public PairValuesNotEqualException() {
            super("\nPair values not equal: " + Pair.this + "\nIn thread " + Thread.currentThread().getName());
        }
    }

    // Arbitrary invariant -- both variables must be equal:
    public void checkState() {
        if(x != y)
            throw new PairValuesNotEqualException();
    }
}

// Protect a Pair inside a thread-safe class:
abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage =
            Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        // Make a copy to keep the original safe:
        return new Pair(p.getX(), p.getY());
    }

    // Assume this is a time consuming operation
    protected void store(Pair p) {
        storage.add(p);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ignore) {}
    }

    public abstract void increment();

}

// Syncronize the entire method:
class PairManager1 extends PairManager {
    public synchronized  void increment() {
        p.incrementX();
        p.incrementY();
        store(p);
    }
}

// Use a critical section:
class PairManager2 extends PairManager {
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        }
        store(temp);
    }
}

// Use a lock object
class PairManager3 extends PairManager {
    private Lock lock = new ReentrantLock();
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}

// Use a synchronized and a lock object
class PairManager4 extends PairManager {
    private Lock lock = new ReentrantLock();
    public synchronized void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            Thread.yield();
            p.incrementY();
            store(p);
        } finally {
            lock.unlock();
        }
    }
}

class PairManipulator implements Runnable {
    private PairManager pm;

    // Constructor
    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(pm.getClass().getName());
        while(true)
            pm.increment();
    }

    @Override
    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter = " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    // Constructor
    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}

public class CriticalSection {
    // Tests the two different approaches:
    static void testApproaches(
            PairManager pman1,
            PairManager pman2,
            PairManager pman3,
            PairManager pman4) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pman1),
                pm2 = new PairManipulator(pman2),
                pm3 = new PairManipulator(pman3),
                pm4 = new PairManipulator(pman4);
        PairChecker
                pcheck1 = new PairChecker(pman1),
                pcheck2 = new PairChecker(pman2),
                pcheck3 = new PairChecker(pman3),
                pcheck4 = new PairChecker(pman4);
        print("before execution");
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pm3);
        exec.execute(pm4);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
        exec.execute(pcheck3);
        exec.execute(pcheck4);
        print("after execution");
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            print("testApproaches interrupted");
        }
        exec.shutdown();
        print("exec.shutdown");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        print("pm1: " + pm1 + "\npm2: " + pm2 + "\npm3: " + pm3 + "\npm4" + pm4);
        System.exit(0);
    }

    public static void main(String... args) {
        PairManager
                pman1 = new PairManager1(),
                pman2 = new PairManager2(),
                pman3 = new PairManager3(),
                pman4 = new PairManager4();
        testApproaches(pman1, pman2, pman3, pman4);
    }

}
