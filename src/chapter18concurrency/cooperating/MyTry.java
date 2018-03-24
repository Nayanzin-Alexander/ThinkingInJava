package chapter18concurrency.cooperating;

import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 06.09.17.
 */


public class MyTry {
    static class Monitor{}
    static boolean exit = false;
    static String str;

    static Runnable readTask = ()-> {
        while(!exit) {
            try{
                Reader.read();
                Printer.doNotify();
            } finally {
                Reader.doWait();
            }
        }
    };
    static Runnable printTask = ()-> {
        Printer.doWait();
        while(!exit) {
            try {
                Printer.printStr();
                Reader.doNotify();
            } finally {
                Printer.doWait();
            }
        }
    };

    static class Printer {
        static Monitor printerMonitor = new Monitor();
        static boolean wasSignaled = false;
        static void printStr() {
            print(str);
        }
        static void doWait() {
            synchronized (printerMonitor) {
                while(!wasSignaled) {
                    try {
                        printerMonitor.wait();
                    } catch (InterruptedException e) {}
                }
                wasSignaled = false;
            }
        }
        static void doNotify() {
            synchronized (printerMonitor) {
                wasSignaled = true;
                printerMonitor.notify();
            }
        }
    }
    static class Reader {
        static Monitor readerMonitor = new Monitor();
        static boolean wasSignaled = false;
         static void read() {
            str = System.console().readLine("Print some chars: ");
            if(str.equals("exit")) {
                exit = true;

            }
        }
        static void doWait() {
            synchronized (readerMonitor) {
                while(!wasSignaled) {
                    try {
                        readerMonitor.wait();
                    } catch (InterruptedException e) {}
                }
                wasSignaled = false;
            }
        }
        static void doNotify() {
            synchronized (readerMonitor) {
                wasSignaled = true;
                readerMonitor.notify();
            }
        }
    }
    public static void main(String... args) {
        new Thread(readTask).start();
        new Thread(printTask).start();
    }
}
