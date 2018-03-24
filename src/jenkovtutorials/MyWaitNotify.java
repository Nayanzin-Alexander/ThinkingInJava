package jenkovtutorials;

import java.util.concurrent.TimeUnit;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.09.17.
 */

class Not1 extends MyWaitNotify {
    @Override
    public void someMethod() {
        while(true) {
            print("not1");
        }
    }
}

class Not2 extends MyWaitNotify {
    @Override
    public void someMethod() {
        while(true) {
            print("not2");
        }
    }
}


public class MyWaitNotify {
    MonitorObject monitor = new MonitorObject();
    boolean wasSignaled = false;

    public void doWait() {
        synchronized (monitor) {
            while(!wasSignaled) {
                try {
                    print("Send wait");
                    monitor.wait();
                } catch (InterruptedException e) {}
            }
            wasSignaled = false;
        }
    }

    public void doNotify() {
        synchronized (monitor) {
            wasSignaled = true;
            monitor.notify();
            print("Notify received");
        }
    }

    public void someMethod() {
    }

    public static void main(String... args) {

    }
}
