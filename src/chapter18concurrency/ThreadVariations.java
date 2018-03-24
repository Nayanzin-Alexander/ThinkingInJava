package chapter18concurrency;

import java.util.concurrent.TimeUnit;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 31.08.17.
 */

// Using a named inner class:
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread {
        // Constructor
        Inner(String name) {
            super(name);
            start();
        }
        @Override
        public void run() {
            try {
                while(true) {
                    print(this);
                    if(--countDown == 0)
                        return;;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                print("interrupted");
            }
        }
        @Override
        public String toString() {
            return getName() + ": " + countDown;
        }
    }

    // Constructor
    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

// Using anonymous inner class
class InnerThread2 {
    private int countDown = 5;
    private Thread inner;

    // Constructor
    public InnerThread2(String name) {
        inner = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        print(this);
                        if (--countDown == 0)
                            return;
                        ;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    print("interrupted");
                }
            }

            @Override
            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        inner.start();
    }
}

// A separate method to run some code as a task:
class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;

    // Constructor
    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if(t == null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    try {
                        while(true) {
                            print(this);
                            if(--countDown == 0) return;
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    } catch(InterruptedException e) {
                        print("sleep() interrupted");
                    }
                }
            };
        }
        t.start();
    }
}

public class ThreadVariations {
    public static void main(String... args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}
