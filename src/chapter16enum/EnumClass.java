package chapter16enum;

import static myutil.Printer.print;
import static myutil.Printer.printInLine;
import chapter2operators.EnumTest;

/**
 * Created by nayanzin on 09.08.17.
 */

enum Shrubbery { GROUND, CRAWLING, HANGING }

public class EnumClass {
    public static void main(String[] args) {
        for(Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal());
            printInLine(s.compareTo(Shrubbery.CRAWLING) + " ");
            printInLine(s.equals(Shrubbery.CRAWLING) + " ");
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());
            print(s.name());
            print("----------------------");
        }

        // Produce an enum value from a string name:
        for(String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            print(shrub);
        }
    }
}
