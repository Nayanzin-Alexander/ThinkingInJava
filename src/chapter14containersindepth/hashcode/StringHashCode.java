package chapter14containersindepth.hashcode;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 29.07.17.
 */
public class StringHashCode {
    public static void main(String... args){
        String[] hellos = "hello hello".split(" ");
        print(hellos[0].hashCode());
        print(hellos[1].hashCode());
    }
}
