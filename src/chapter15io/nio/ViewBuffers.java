package chapter15io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;

/**
 * Created by nayanzin on 05.08.17.
 */
public class ViewBuffers {
    public static void main(String... args) {
        ByteBuffer bb = ByteBuffer.wrap(
                new byte[] {0,0,0,0,0,0,0,'a'});
        bb.rewind();
        printInLine("Byte Buffer");
        while(bb.hasRemaining())
            printInLine(bb.position() + "->" + bb.get() + " ");
        bb.rewind();
        print();

        CharBuffer cb = bb.asCharBuffer();
        printInLine("Char buffer");
        while(cb.hasRemaining())
            printInLine(cb.position() + "->" + cb.get() + " ");
        cb.rewind();
        print();

        DoubleBuffer db = bb.asDoubleBuffer();
        printInLine("Double buffer");
        while(db.hasRemaining())
            printInLine(db.position() + "->" + db.get() + " ");
        db.rewind();
        print();
    }
}
