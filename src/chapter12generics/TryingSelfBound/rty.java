package chapter12generics.TryingSelfBound;

/**
 * Created by nayanzin on 19.07.17.
 */

interface MyComparable<T extends MyComparable<T>>{
    int compareTo(T o);
}

interface Pet extends MyComparable<Pet> {
    int getID();
}
interface Cat extends Pet{}
interface Dog extends Pet{}

class PetClass implements Pet{
    private static int count = 0;
    private final int PET_ID = count++;

    @Override
    public int compareTo(Pet o) {
        return this.PET_ID - o.getID();
    }

    @Override
    public int getID(){
        return PET_ID;
    }
}

class CatClass extends PetClass implements Cat{
    private static int count = 0;
    private final int CAT_ID = count++;

    @Override
    public int getID(){
        return CAT_ID;
    }
}

public class rty {
    public static void main(String... args){
        CatClass cat1 = new CatClass();
        cat1.compareTo(new CatClass());
        cat1.compareTo(new PetClass()); //not good. Compare is not overriden.
    }
}
