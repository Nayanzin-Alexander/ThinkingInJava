package chapter15io;

import java.io.IOException;
import java.io.RandomAccessFile;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.08.17.
 */

public class UsingRandomAccessFile {
    static String file = "/home/nayanzin/derby.log";

    static void display() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        for(int i = 0; i < 7; i++)
            print("Value " + i + " : " + raf.readDouble());
        print(raf.readUTF());
        raf.close();
    }

    static void printBytes() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        long pos = 0;
        long length = raf.length();
        while(pos < length){
            raf.seek(pos);
            //print(raf.readByte());
            pos += 8;
        }

        raf.seek(8);
        pos = 8;
        while(pos < length){
            raf.seek(pos);
            byte byte1 = raf.readByte();
            pos += 8;
            if(pos < length) {
                byte byte2 = raf.readByte();
                pos += 8;
                print(getDouble(byte1, byte2));
            }
        }
    }

    static Long getLong(byte byte1, byte byte2){
        return ((long)((int) byte1) << 32) + ( (int) byte2 & 0xFFFFFFFFL);
    }

    static Double getDouble(byte byte1, byte byte2){
        return Double.longBitsToDouble(getLong(byte1, byte2));
    }

    public static void main(String... args)  throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        for(int i=0; i < 7; i++)
            raf.writeDouble(10D);

        //raf.writeUTF("The end of file");
        raf.close();
        printBytes();
    }
}
