package chapter18concurrency;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 27.08.17.
 */
public class BasicsThread {
    public static void main(String... args) {
        new Thread(new LiftOff()).start();
        new Thread(new LiftOff()).start();
        new Thread(new LiftOff()).start();
        new Thread(new LiftOff()).start();
        new Thread(new LiftOff()).start();
        print("Wating for LiftOff");
    }
}
