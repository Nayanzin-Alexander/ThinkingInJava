package chapter14containersindepth;

import chapter12generics.Generator;
import myutil.CountingGenerator;
import myutil.RandomGenerator;

import java.util.Iterator;
import java.util.Map;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 26.07.17.
 */

class Letters implements Generator<Pair<Integer, String>>,
        Iterable<Integer>{
    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    public Pair<Integer,String> next() {
        return new Pair<Integer,String>(number++, "" + letter++);
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public Integer next() { return number++; }
            public boolean hasNext() { return number < size; }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

}

public class MapDataTest {
    public static void main(String... args){

        // A single pair generator
        print(MapData.map(new Letters(), 10));

        // Two separate Generators
        print(MapData.map(new RandomGenerator.Integer(), new RandomGenerator.Character(), 10));

        // A key generator and a single value
        print(MapData.map(new CountingGenerator.Boolean(), "SSS", 10));

        // An Iterable and a value Generator:
        print(MapData.map(new Letters(), "Pop"));


    }
}
