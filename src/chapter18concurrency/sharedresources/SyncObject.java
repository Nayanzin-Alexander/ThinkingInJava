package chapter18concurrency.sharedresources;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 02.09.17.
 */

class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f() {
        for(int i= 0; i < 5; i++) {
            print("f()");
            Thread.yield();
        }
    }
    public void g() {
        synchronized (syncObject) {
            for(int i= 0; i < 5; i++) {
                print("d()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String... args) {
        final DualSynch ds = new DualSynch();
        new Thread(()->ds.f()).start();
        ds.g();
    }
}
