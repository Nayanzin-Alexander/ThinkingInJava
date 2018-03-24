package chapter8containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.07.17.
 */

class MyList<E> extends ArrayList<E> {
     public MyList(){
        super();
    };

     public Iterable<E> getBackwardIterable(){
         return new Iterable<E>(){
             @Override
             public Iterator<E> iterator() {
                 return new Iterator<E>(){
                     int current = MyList.this.size() - 1;

                     @Override
                     public boolean hasNext() {
                         return current > -1;
                     }

                     @Override
                     public E next() {
                         return MyList.this.get(current--);
                     }
                 };
             }
         };
     }

     public Iterable<E> getShuffleIterable(){
         return new Iterable<E>() {
             @Override
             public Iterator<E> iterator() {
                 return new Iterator<E>() {
                     private List<E> newList = new ArrayList<>(MyList.this);
                     private int current = 0;
                     {
                         Collections.shuffle(newList);
                     }
                     @Override
                     public boolean hasNext() {
                         return current < newList.size();
                     }

                     @Override
                     public E next() {
                         return newList.get(current++);
                     }
                 };
             }
         };
     }
}

public class AdapterMethodIdiom {
    public static void main(String... args){
        MyList<Integer> list = new MyList<>();
        for(int i=0; i<10; i++){
            list.add(i*i);
        }

        for(int el : list){
            print(el);
        }

        for(int el : list.getBackwardIterable()){
            print(el);
        }

        for(int el : list.getShuffleIterable()){
            print(el);
        }


    }
}
