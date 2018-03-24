package chapter12generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 13.07.17.
 */
public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static <T> Set<T> difference(Set<T> a, Set<T> b){
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b){
        Set<T> result = difference(union(a,b), intersection(a,b));
        return result;
    }

    public static void main(String... args){
        Set<Integer> set1 =new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 =new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        print(intersection(set1, set2));

    }
}
