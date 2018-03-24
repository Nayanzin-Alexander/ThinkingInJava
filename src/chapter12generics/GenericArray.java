package chapter12generics;

import java.util.Iterator;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 16.07.17.
 */
public class GenericArray<T> {
    private Object[] array;
    public GenericArray(int size){
        array = new Object[size];
    }
    public void put(int index, T item){
        array[index] = item;
    }
    public T get(int index){
        return (T) array[index];
    }
    public T[] rep(){
        return (T[]) array;
    }

    public Iterable<T> getIterable(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = 0;
                    @Override
                    public boolean hasNext() {
                        return current < array.length;
                    }

                    @Override
                    public T next() {
                        return (T) array[current++];
                    }
                };
            }
        };
    }

    public static void main(String... args){
        GenericArray<Integer> ga = new GenericArray<>(10);
        for(int i=0; i<10; i++){
            ga.put(i, i*i);
        }
        for(int element : ga.getIterable()){
            print(element);
        }

    }
}
