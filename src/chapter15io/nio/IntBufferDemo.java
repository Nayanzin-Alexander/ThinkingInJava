package chapter15io.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 05.08.17.
 */
public class IntBufferDemo {
    private static final int BSIZE = 1024;
    public static void main(String... args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();

        // Store an array of int:
        ib.put(new int[]{11,42,47,99,143,811,1016});

        // Absolute location read and write:
        print(ib.get(3));

        // Setting a new limit bfore rewinding the buffer
        ib.flip();
        while(ib.hasRemaining()){
            int i = ib.get();
            print(i);
        }
    }
}
