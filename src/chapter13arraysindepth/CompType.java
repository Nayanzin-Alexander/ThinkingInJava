package chapter13arraysindepth;

import chapter12generics.Generator;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import myutil.Generated;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.07.17.
 */
public class CompType implements Comparable<CompType>{
    private int a;
    private int b;
    public CompType(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(CompType o) {
        return a - o.a;
    }

    @Override
    public String toString(){
        return "a= " + a + "  b= " + b;
    }

    public Comparator<CompType> getComparator(){
        return new Comparator<CompType>() {

            @Override
            public int compare(CompType o1, CompType o2) {
                return o1.b - o2.b;
            }
        };
    }

    public static Generator<CompType> generator(){
        return new Generator<CompType>() {
            Random rand = new Random(47);
            @Override
            public CompType next() {
                return new CompType(rand.nextInt(10), rand.nextInt(10));
            }
        };
    }

    public static void main(String... args){

        CompType[] array = Generated.array(new CompType[10], CompType.generator());

        print(Arrays.toString(array));

        Arrays.sort(array);

        Comparator<CompType> comparator = array[0]. getComparator();

        Arrays.sort(array, comparator);

        print(Arrays.toString(array));
    }
}
