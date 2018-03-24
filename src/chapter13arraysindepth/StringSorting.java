package chapter13arraysindepth;

import myutil.CountingGenerator;
import myutil.Generated;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.07.17.
 */
public class StringSorting {
    public static void main(String... args){
        String[] strings = Generated.array(new String[10], new CountingGenerator.String());
        print(Arrays.toString(strings));

        Arrays.sort(strings);
        print(Arrays.toString(strings));

        Arrays.sort(strings, Collections.reverseOrder());
        print(Arrays.toString(strings));

        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
        print(Arrays.toString(strings));

    }
}
