package chapter15io.nio;

import java.nio.ByteBuffer;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;

/**
 * Created by nayanzin on 05.08.17.
 */
public class Primitives {
    private static final int BSIZE = 1024;

    public static void main(String... args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // Allocation automatically zeroes the ByteBuffer:
        int i =0;
        while(i++ < bb.limit()) {
            if(bb.get() != 0)
                print("nonzero");
        }

        bb.rewind();

        // Store and read char array:
        bb.asCharBuffer().put("Hosws!");
        char c;
        while ((c = bb.getChar()) != 0)
            printInLine(c+" ");
        print();
        bb.rewind();

        // Store and read short
        bb.asShortBuffer().put( (short) 471142);
        print(" short " + bb.getShort());
        bb.rewind();

        // Store and read int:
        bb.asIntBuffer().put(99471142);
        print(" int " + bb.getInt());

        // Other primitives goes the same.




    }
}
