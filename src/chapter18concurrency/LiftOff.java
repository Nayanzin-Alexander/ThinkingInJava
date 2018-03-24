package chapter18concurrency;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 27.08.17.
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }
    public void run() {
        while(countDown-- > 0) {
            print(status());
            Thread.yield();
        }
    }
}