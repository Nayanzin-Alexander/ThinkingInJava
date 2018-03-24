package chapter15io.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;

/**
 * Created by nayanzin on 05.08.17.
 */
public class Endians {
    public static void main(String... args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        while(bb.hasRemaining())
            printInLine(bb.getChar());
        bb.rewind();
        print();

        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        while(bb.hasRemaining())
            printInLine(bb.getChar());
        bb.rewind();
        print();

        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        while(bb.hasRemaining())
            printInLine(bb.getChar());
    }
}
