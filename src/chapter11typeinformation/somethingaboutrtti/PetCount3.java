package chapter11typeinformation.somethingaboutrtti;

import java.util.LinkedHashMap;
import java.util.Map;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 11.07.17.
 */
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer>{
        public PetCounter(){
            super();
            for(Class<? extends Pet> petType : LiteralPetCreator.allTypes){
                this.put(petType, 0);
            }
        }

        public void count(Pet pet){
            for(Map.Entry<Class<? extends Pet>,Integer> pair : this.entrySet())
                if(pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue() + 1);
        }
    }

    public static void main(String... args){

        PetCounter petCount = new PetCounter();
        for(Pet pet : Pets.createArray(20)) {
            petCount.count(pet);
        }
        print();
        print(petCount);
    }
}
