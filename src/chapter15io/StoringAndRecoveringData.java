package chapter15io;

import java.io.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.08.17.
 */
public class StoringAndRecoveringData {
    static String fileName = "/home/nayanzin/data.txt";
    public static void main(String... args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName)));
        for(int i=0; i<10; i++) {
            out.writeDouble(153D);
            out.writeBoolean(true);
            out.writeInt(55);
            out.writeFloat(55F);
            out.writeUTF("dfdg");
            byte[] bytes = {Integer.valueOf(55).byteValue()};
            out.write(bytes);

        }
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)));
        while(in.available() != 0) {
            print();
            System.out.println(in.readDouble());
            System.out.println(in.readBoolean());
            System.out.println(in.readInt());
            System.out.println(in.readFloat());
            // Only readUTF() will recover the
            // Java-UTF String properly:
            System.out.println(in.readUTF());
            byte[] bytes = new byte[1];
            in.read(bytes);
            for(byte byte1 : bytes){
                System.out.println((int) byte1);
            }
        }
        out.close();
    }
}