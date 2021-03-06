package chapter11typeinformation.somethingaboutrtti;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by nayanzin on 10.07.17.
 */
public abstract class PetCreator {
    private Random rand = new Random(47);

    public List<Class<? extends Pet>> types(){
        return Arrays.asList(
                Pet.class, Dog.class, Cat.class, Rodent.class,
                Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                Cymric.class, Rat.class, Mouse.class,Hamster.class
        );
    };

    //Create one random pet
    public Pet randomPet(){
        int n = rand.nextInt(types().size());
        try{
            return types().get(n).newInstance();
        }catch(InstantiationException e){
            throw new RuntimeException(e);
        }catch(IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size){
        Pet[] result = new Pet[size];
        for(int i = 0; i < size; i++){
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList(int size){
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
