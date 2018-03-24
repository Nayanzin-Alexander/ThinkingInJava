package chapter15io.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;
import java.util.TreeMap;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 05.08.17.
 */
public class AvaibleCharsets {
    public static void main(String... args) {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        print(map);
    }
}
