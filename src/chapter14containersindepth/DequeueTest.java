package chapter14containersindepth;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.07.17.
 */
public class DequeueTest {
    public static void main(String... args){
        Deque<Integer> deq = new LinkedList<Integer>();
        deq.addFirst(1);
        deq.offerLast(9);
        deq.addFirst(0);
        deq.offerLast(10);
        Iterator<Integer> it = deq.descendingIterator();
        while(it.hasNext())
            print(it.next());
        while(deq.size()!=0)
            print(deq.removeLast());
    }
}
