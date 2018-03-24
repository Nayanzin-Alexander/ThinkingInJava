package chapter11typeinformation.somethingaboutrtti;

import java.util.HashMap;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 10.07.17.
 */
public class PetCount {

    static class PetCounter extends HashMap<String, Integer>{
        public void count(String type){
            Integer quantity = this.get(type);
            if(quantity == null)
                this.put(type, 1);
            else
                this.put(type, ++quantity + 1);
        }
    }

    public static void countPets(PetCreator creator){
        PetCounter counter = new PetCounter();
        for(Pet pet : creator.arrayList(20)){
            if(pet instanceof Pet)
                counter.count("Pet");
            if(pet instanceof Dog)
                counter.count("Dog");
            if(pet instanceof Mutt)
                counter.count("Mutt");
            if(pet instanceof Pug)
                counter.count("Pug");
            if(pet instanceof Cat)
                counter.count("Cat");
            if(pet instanceof Manx)
                counter.count("EgyptianMau");
            if(pet instanceof Manx)
                counter.count("Manx");
            if(pet instanceof Manx)
                counter.count("Cymric");
            if(pet instanceof Rodent)
                counter.count("Rodent");
            if(pet instanceof Rat)
                counter.count("Rat");
            if(pet instanceof Mouse)
                counter.count("Mouse");
            if(pet instanceof Hamster)
                counter.count("Hamster");
        }
        print(counter);
    }

    public static void main(String... args) throws IllegalAccessException, InstantiationException {
        countPets(Pets.creator);
    }
}
