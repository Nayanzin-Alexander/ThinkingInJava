package chapter14containersindepth;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 31.07.17.
 */
public class RandomBounds {

    public static void main(String[] args) {
        while(Math.random() != 0.0)
            ; // Keep trying
        print("Produced 0.0!");

        while(Math.random() != 1.0)
            ; // Keep trying
        print("Produced 1.0!");
    }
}
