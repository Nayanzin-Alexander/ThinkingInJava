package chapter2operators;

import java.util.Arrays;

/**
 * Created by nayanzin on 23.06.17.
 */
public class ArraysTest {
    public static void main(String[] args){
        Integer[] a1 = {
            new Integer(10),
            new Integer(11),
            3}; //autoboxing


        Integer[] a2 = new Integer[]{
                new Integer(10),
                new Integer(11),
                3,}; // last comma is optional
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }
}
