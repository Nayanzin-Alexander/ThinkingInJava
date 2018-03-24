package chapter15io.nio;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;

/**
 * Created by nayanzin on 05.08.17.
 */
public class LargeMappedFiles {
    static int length = Integer.MAX_VALUE; // 128 MB
    public static void main(String... args) throws Exception {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw")
                        .getChannel()
                        .map(FileChannel.MapMode.READ_WRITE, 0, length);
        // TestJunit1 1
        long startTime = System.nanoTime();
        for(int i = length/2; i < length/2 + 10; i++)
            printInLine((char)out.get(i));
        long endTime = System.nanoTime();
        print("Time for MappedByteBuffer: " + (endTime - startTime));

        // TestJunit1 2
        startTime = System.nanoTime();
        for(int i = length/2; i < length/2 + 10; i++)
            printInLine((char)out.get(i));
        endTime = System.nanoTime();
        print("Time for MappedByteBuffer: " + (endTime - startTime));


        RandomAccessFile out2 = new RandomAccessFile("test.dat", "rw");

        // TestJunit1 1
        startTime = System.nanoTime();
        out2.seek(length/2);
        for(int i = 0; i < 10; i++)
            printInLine((char)out2.read());
        endTime = System.nanoTime();
        print("Time RandomAccessFile: " + (endTime - startTime));

        // TestJunit1 2
        startTime = System.nanoTime();
        out2.seek(length/2);
        for(int i = 0; i < 10; i++)
            printInLine((char)out2.read());
        endTime = System.nanoTime();
        print("Time RandomAccessFile: " + (endTime - startTime));

    }
}
