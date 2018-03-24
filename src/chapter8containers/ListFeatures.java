package chapter8containers;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.07.17.
 */
class Pet {
    private String name;

    public Pet(int i){
        switch (i){
            case 0:{name = "Mouse";} break;
            case 1:{name = "Rat";} break;
            case 2:{name = "Cat";} break;
            case 3:{name = "Mutt";} break;
            case 4:{name = "Pug";} break;
            case 5:{name = "Cymric";} break;
            case 6:{name = "Manx";} break;
            case 7:{name = "Dog";} break;
            case 8:{name = "Lion";} break;
            case 9:{name = "Elephant";} break;
            default:{name = "Cow";} break;
        }
    }

    public static List<Pet> arrayList(int size){
        List<Pet> list = new ArrayList<>();
        for(int i=0; i<size; i++){
            list.add(new Pet(i));
        }
        return list;
    }

    @Override
    public String toString(){
        return name;
    }
}

public class ListFeatures {
    public static void main(String... args){
        List<Pet> pets = Pet.arrayList(10);
        print("1 " + pets);

        Pet pet = new Pet(1);
        pets.add(pet);
        print("2 " + pets);
        print("3 " + pets.contains(pet));
        pets.remove(pet);
        print("4 " + pets);

        pet = pets.get(2);
        print("5 "+pet+pets.indexOf(pet));

        List<Pet> subList = pets.subList(3, 6);
        print("6 " + subList);
        List<Integer> list1 = new ArrayList();
        Collections.addAll(list1,1,2,3,4,5,6,7,8,9);
        List<Integer> list2 = new ArrayList();
        Collections.addAll(list2,5,6,7,8,9,10,11,12,13,14,15);

        List<Integer> left = new ArrayList<>(list1);
        left.removeAll(list2);
        print("left join " + left);

        List<Integer> right = new ArrayList<>(list2);
        right.removeAll(list1);
        print("right join " + right);

        List<Integer> center = new ArrayList<>(list1);
        center.retainAll(list2);
        print("center join " + center);

        List<Integer> all = new ArrayList<>();
        all.addAll(list1);
        all.addAll(list2);
        print("All " + all);

        ListIterator iterator = all.listIterator();
        while(iterator.hasNext()){
            print(iterator.previousIndex() + " " +
                iterator.nextIndex() + " " +
                iterator.next());
        }
        print(all);
    }
}
