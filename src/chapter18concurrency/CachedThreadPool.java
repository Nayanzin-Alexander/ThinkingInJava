package chapter18concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nayanzin on 27.08.17.
 */
public class CachedThreadPool {
    public static void main(String... args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
    }
}
