package chapter8containers;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.07.17.
 */
public class Statistics {
    public static void main(String... args){
        Random rand = new Random(47);
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i = 0; i < 10000; i++) {
            // Produce a number between 0 and 20:
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            freq = freq == null? 1: freq+1;
            m.put(r, freq);
        }
        print(m);

    }
}
