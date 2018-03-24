package chapter16enum;

import chapter12generics.Generator;

import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 14.08.17.
 */

enum CartoonCharacter
    implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);
    public CartoonCharacter next()  {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> gen) {
        print(gen.next() + ".");
    }

    public static void main(String... args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i=0; i<10; i++) {
            printNext(cc);
        }
    }
}
