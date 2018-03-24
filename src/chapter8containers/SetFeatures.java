package chapter8containers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.07.17.
 */
public class SetFeatures {
    public static void main(String... args){
        Set<Integer> set = new TreeSet<>();
        Random random = new Random(47);
        for(int i=0; i < 10000; i++)
            set.add(random.nextInt(30));
        print(set);
    }
}
