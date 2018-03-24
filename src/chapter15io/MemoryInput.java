package chapter15io;

import java.io.IOException;
import java.io.StringReader;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.08.17.
 */
public class MemoryInput {
    public static void main(String[] args)
            throws IOException {
        StringReader in = new StringReader(
                ReadText.read("MemoryInput.java"));
        int c;
        while((c = in.read()) != -1)
            System.out.print((char)c);
        String s;

    }
}
