package chapter18concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.09.17.
 */

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        print("Caught " + e);
    }
}

public class ExceptionThread implements Runnable {
    private static ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r){
            Thread t = new Thread(r);
            t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            return t;
        }
    };

    @Override
    public void run(){
        throw new RuntimeException("Exception from the thread");
    }

    public static void main(String... args) {
        ExecutorService exec = Executors.newCachedThreadPool(threadFactory);
        try {
            exec.execute(threadFactory.newThread(new ExceptionThread()));
        } catch (Exception e) {
            print("Exception caught");
        }
    }
}
