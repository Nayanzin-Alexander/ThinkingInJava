package chapter18concurrency;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 31.08.17.
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        // Store the thread name
        super(Integer.toString(++threadCount));
        setDaemon(true);
        start();
    }

    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    public void run() {
        while(true) {
            print(this);
            Thread.yield();
            if(--countDown == 0)
                return;
        }
    }

    public static void main(String... args) {
        for(int i = 0; i< 5; i++) {
            new SimpleThread();
        }
    }
}
