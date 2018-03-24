package jenkovtutorials;

import java.util.concurrent.TimeUnit;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.09.17.
 */
public class MyThread {
    static long counter;
    static volatile boolean run = true;



    public static void main(String... args) {

        Runnable r1 = ()->{
            for(int i=0; i < 1000000; i++)
                counter++;
            run = false;
        };

        Runnable r2 = ()->{
            long localCounter = 0;
            while(run) {
                localCounter = counter;
            }
            print("localCounter= " + localCounter);
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r2);
        Thread t4 = new Thread(r2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
