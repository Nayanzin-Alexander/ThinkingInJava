package chapter18concurrency.responsiveui;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.09.17.
 */

class UnresponciveUI {
    private volatile double d =1;
    public UnresponciveUI() throws Exception {
        while(d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read(); // never gets here
    }
}

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    public void run() {
        while(d > 0)
            d = d + (Math.PI + Math.E) / d;
    }

    public static void main(String... args) throws Exception {
        //new UnresponciveUI();
        new ResponsiveUI();
        System.in.read();
        print(d);
    }
}
