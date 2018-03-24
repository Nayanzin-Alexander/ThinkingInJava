package chapter18concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Created by nayanzin on 31.08.17.
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
