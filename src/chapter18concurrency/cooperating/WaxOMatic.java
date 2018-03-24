package chapter18concurrency.cooperating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 06.09.17.
 */

class Shared {
    private boolean task1On = false;

    public synchronized void task1Comlete() {
        task1On = true; // Ready to buff
        notifyAll();
    }

    public synchronized void task2Complete() {
        task1On = false; // Ready to another coat of wax
        notifyAll();
    }

    public synchronized void waitForTask1()
        throws InterruptedException {
        while(task1On == false)
            wait();
    }

    public synchronized void waitForTask2()
        throws InterruptedException {
        while(task1On == true)
            wait();
    }
}

class task1 implements Runnable {
    private Shared car;

    // Constructor
    public task1(Shared c) { car = c; }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                print("Task1 running");
                TimeUnit.MILLISECONDS.sleep(200);
                car.task1Comlete();
                car.waitForTask2();
            }
        } catch(InterruptedException e) {
            print("Exiting task1 via interrupt");
        }
        print("Ending task1");
    }
}

class task2 implements Runnable {
    private Shared car;

    // Constructor
    public task2(Shared c) { car = c; }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForTask1();
                print("Task2");
                TimeUnit.MILLISECONDS.sleep(200);
                car.task2Complete();
            }
        } catch (InterruptedException e) {
            print("Exit task2 via interrupt");
        }
        print("Ending task2");
    }
}

public class WaxOMatic {
    public static void main(String... args) throws Exception {
        Shared car = new Shared();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new task2(car));
        exec.execute(new task1(car));
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}
