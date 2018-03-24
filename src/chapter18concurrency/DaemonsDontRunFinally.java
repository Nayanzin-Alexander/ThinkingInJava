package chapter18concurrency;

import java.util.concurrent.TimeUnit;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 31.08.17.
 */

class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            print("Starting ADaemon");
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        } finally {
            print("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String... arg) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
