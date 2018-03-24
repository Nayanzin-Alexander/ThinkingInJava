package chapter11typeinformation.somethingaboutrtti;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 11.07.17.
 */
public class PetCounter4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Individual.class);
        for(Pet pet : Pets.createArray(20)) {
            counter.count(pet);
        }
        print(counter);
    }
}
