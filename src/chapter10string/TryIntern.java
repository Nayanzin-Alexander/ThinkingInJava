package chapter10string;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 06.07.17.
 */
public class TryIntern{


    public static void main(String... args){

        String str = String.format("%f, %<+020.10f %n", Math.PI);
        print(str);
    }
}
