package chapter18concurrency.interrupting;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 06.09.17.
 */
public class MultiLock {
    public synchronized void f1(int count) {
        if(count-- > 0) {
            print("f1() calling f2() whith count " + count);
            f2(count);
        }
    }
    public synchronized void f2(int count) {
        if(count-- > 0) {
            print("f2() callint f1() with count " + count);
            f1(count);
        }
    }
    public static void main(String... args) {
        final MultiLock multilock = new MultiLock();
        new Thread(()->multilock.f1(10)).start();
    }
}
