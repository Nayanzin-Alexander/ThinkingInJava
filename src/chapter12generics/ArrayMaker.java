package chapter12generics;

import java.lang.reflect.Array;
import java.util.Arrays;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 13.07.17.
 */
public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker(Class<T> kind){
        this.kind = kind;
    }

    T[] create(int size){
        return (T[]) Array.newInstance(kind, size);
    }


    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        print(stringArray);
    }
}
