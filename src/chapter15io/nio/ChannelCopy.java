package chapter15io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by nayanzin on 05.08.17.
 */
public class ChannelCopy {
    public static void copy(String src, String dest) throws IOException{
        FileChannel out = new FileOutputStream(dest).getChannel();
        FileChannel in = new FileInputStream(src).getChannel();

        out.transferFrom(in,0, out.size());
    }

    public static void main(String... args) throws IOException{
        copy("data.txt", "data2.txt");
    }
}
