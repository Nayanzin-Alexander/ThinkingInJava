package chapter13arraysindepth;

import chapter12generics.Generator;
import myutil.Generated;
import myutil.RandomGenerator;

import java.util.Arrays;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.07.17.
 */
public class ArraySearch {
    public static void main(String... args){
        Generator<Integer> gen = new RandomGenerator.Integer();

        Integer[] ints = Generated.array(Integer.class, gen, 7);
        Arrays.sort(ints);
        print(Arrays.toString(ints));


        boolean notFind = true;
        while(notFind){
            int r = gen.next();
            int location = Arrays.binarySearch(ints, r);
            if(location >= 0){
                notFind = false;
                print("Found " + r + "  in location " + location);
            }


        }
    }
}
