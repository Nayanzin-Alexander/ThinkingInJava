package chapter14containersindepth;

import myutil.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 26.07.17.
 */
public class CollectionDataGenerator {
    public static void main(String... args){
        print(new ArrayList<String>(
                CollectionData.list(
                        new RandomGenerator.String(3), 10)));

        print(new HashSet<Integer>(
                CollectionData.list(
                        new RandomGenerator.Integer(), 10)));
    }
}
