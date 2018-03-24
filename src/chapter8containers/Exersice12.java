package chapter8containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.07.17.
 * Exercise 12: (3) Create and populate a List<Integer>.
 * Create a second List<Integer> of the same size as the first,
 * and use ListIterators to read elements from the first List and
 * insert them into the second in reverse order.
 * (You may want to explore a number of different ways to solve this problem.)
 */
public class Exersice12 {
    public static void main(String... args){
        List<Integer> list1 = new ArrayList();
        Collections.addAll(list1, 1,2,3,4,5,6,7,8,9,10);
        List<Integer> list2 = new ArrayList(list1.size());
        list2.addAll(list1);

        ListIterator<Integer> it1 = list1.listIterator();
        ListIterator<Integer> it2 = list2.listIterator(list2.size());
        while(it1.hasNext()){
            if(it2.hasPrevious()){
                it2.previous();
                it2.set(it1.next());
            }else{
                it1.next();
            }
        }
        print(list1);
        print(list2);
    }
}
