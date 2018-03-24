package chapter14containersindepth;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 27.07.17.
 */
public class TestIterator {
    static List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

    public static void main(String... args){
        ListIterator<Integer> lit = list.listIterator(3);
        print(lit.nextIndex());
        print(lit.next());
        print(lit.nextIndex());
        lit.set(0);
        lit.add(9);
        print(lit.previous());
        print(list);

    }
}
