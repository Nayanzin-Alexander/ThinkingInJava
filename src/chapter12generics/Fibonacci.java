package chapter12generics;

import java.util.Iterator;

/**
 * Created by nayanzin on 13.07.17.
 */
public class Fibonacci implements Generator<Integer>{
    int first = 0;
    int second = 1;

    @Override
    public Integer next(){
        int result = first + second;
        first = second;
        second = result;
        return result;
    }

    public Iterable<Integer> getIterable(int threshold){
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    int count = 0;
                    @Override
                    public boolean hasNext() {
                        return threshold > count;
                    }

                    @Override
                    public Integer next() {
                        count++;
                        return Fibonacci.this.next();
                    }
                };
            }
        };
    }
}

