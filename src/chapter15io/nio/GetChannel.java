package chapter15io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by nayanzin on 05.08.17.
 */
public class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String... args) throws Exception {
        // Write a file:
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        // Add to the end of the file:
        fc = new RandomAccessFile("data.txt" , "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap(" Some more".getBytes()));

        // Read the file:
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining())
            System.out.print((char)buff.get());
    }
}
