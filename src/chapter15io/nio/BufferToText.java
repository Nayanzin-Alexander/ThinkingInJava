package chapter15io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 05.08.17.
 */
public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String... args) {
        try {
            FileChannel channel = new FileInputStream("data.txt").getChannel();
            ByteBuffer buff = ByteBuffer.allocate(BSIZE);
            while( channel.read(buff) != -1) {
                buff.flip();
                buff.rewind();
                String encoding = System.getProperty("file.encoding");
                print(Charset.forName(encoding).decode(buff));
                buff.clear();
            }
            channel.close();

            // Or, we could encode with something that will print:
            channel = new FileOutputStream("data.txt").getChannel();
            channel.write(ByteBuffer.wrap("SOMETEXT".getBytes("UTF-16BE")));
            channel.close();

            // Now try reading again:
            channel = new FileInputStream("data.txt").getChannel();
            while (channel.read(buff) != -1) {
                buff.flip();
                print(buff.asCharBuffer());
                buff.clear();
            }
            channel.close();

            // Use a CharBuffer to write through:
            channel = new FileOutputStream("data2.txt").getChannel();
            buff = ByteBuffer.allocate(24);
            buff.asCharBuffer().put("Some text");
            channel.write(buff);
            buff.clear();
            channel.close();

            // Read and display
            channel = new FileInputStream("data2.txt").getChannel();
            while (channel.read(buff) != -1) {
                buff.flip();
                print(buff.asCharBuffer());
                buff.clear();
            }
            channel.close();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
