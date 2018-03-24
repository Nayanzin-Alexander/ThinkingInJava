package chapter8containers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.07.17.
 * Exercise 14: (3) Create an empty LinkedList<Integer>. Using a Listlterator,
 * add Integers to the List by always inserting them in the middle of the List.
 */
public class Exercise14 {
    public static void main(String... args){
        LinkedList<Integer> list1 = new LinkedList<>();

        for(int i=1; i <= 20; i++){
            int middle = list1.size() / 2;
            list1.add(middle, i);
        }

        print(list1);
    }

}
