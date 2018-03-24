package jenkovtutorials;

import chapter18concurrency.sharedresources.ThreadLocalVariableHolder;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.09.17.
 */
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
            @Override
            public Integer initialValue() {
                return new Integer(0);
            }
        };

        @Override
        public void run() {
            threadLocal.set( (int) (Math.random() * 100D) );

            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {}
            print(threadLocal.get());
        }
    }

    public static void main(String... args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
