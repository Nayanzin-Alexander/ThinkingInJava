package chapter18concurrency.interrupting;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 06.09.17.
 */
public class CloseResources {
    public static void main(String... args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));

        TimeUnit.MILLISECONDS.sleep(100);
        print("Shutting sown all threads");
        exec.shutdownNow();

        TimeUnit.SECONDS.sleep(1);
        print("Closing " + socketInput.getClass().getSimpleName());
        socketInput.close();

        TimeUnit.SECONDS.sleep(1);
        print("Closing " + System.in.getClass().getSimpleName());
        System.in.close();

    }
}
