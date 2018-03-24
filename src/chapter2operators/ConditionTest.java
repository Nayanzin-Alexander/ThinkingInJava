package chapter2operators;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 22.07.17.
 */
public class ConditionTest {
    public static void main(String... args){
        boolean op1 = true;
        boolean op2 = true;
        boolean op3 = true;
        boolean result = !op1 & op2 || op3;
        print(result);

    }
}
