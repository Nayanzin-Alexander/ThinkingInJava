package chapter2operators;

import java.util.*;

/**
 * Created by nayanzin on 21.06.17.
 */
public class MathOperators {
    public static void main(String[] args){
        Random random = new Random(47); //Creates seeded random number generator
        double i = random.nextFloat() + 1;
        double j = 1E15f;

        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("i + j = " + (i + j));
        System.out.println("i - j = " + (i - j));
        System.out.println("i * j = " + (i * j));
        System.out.println("i / j = " + (i / j));
        System.out.println("i % j = " + (i % j));
    }
}
