package chapter18concurrency;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.09.17.
 */

class Sleeper extends Thread {
    private int duration;

    // Constructor
    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            print(getName() + " was interrupted");
        }
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    // Constructor
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            print("Interrupted");
        }
        print(getName() + " joing completed");
    }
}

public class Joining {
    public static void main(String... args) {
        Sleeper
                sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);

        grumpy.interrupt();
    }
}
