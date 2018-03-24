package chapter16enum.roshambo;

import myutil.Enums;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 20.08.17.
 */
public class RoShamBo {
    public static <T extends Competitor<T>> void match(T a, T b) {
        print(a + " vs " + b + ": " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>>
            void play(Class<T> rsbClass, int size) {
        for(int i = 0; i < size; i++)
            match(
                    Enums.random(rsbClass), Enums.random(rsbClass)
            );
    }
}
