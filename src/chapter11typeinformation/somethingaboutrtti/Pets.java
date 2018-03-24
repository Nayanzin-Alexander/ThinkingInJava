package chapter11typeinformation.somethingaboutrtti;

import java.util.ArrayList;

/**
 * Created by nayanzin on 11.07.17.
 */
public class Pets {
    public static PetCreator creator = new LiteralPetCreator();
    public static Pet randomPet(){
        return creator.randomPet();
    }
    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
