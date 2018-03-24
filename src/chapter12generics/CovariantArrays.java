package chapter12generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nayanzin on 17.07.17.
 */
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

public class CovariantArrays {
    public static void main(String... args){
        Fruit[] apples = new Apple[10];
        apples[0] = new Jonathan();
        apples[1] = new Apple();
        //! apples[2] = new Fruit(); - ArraySoreExceptiont

        //But we can do
        apples = new Fruit[5];
        apples[0] = new Jonathan();
        apples[1] = new Apple();
        apples[2] = new Fruit();

        //Here is exaple of invariant generics
        //! List<Fruit> fruits = new ArrayList<Apple>(); compile-time error
        List<Apple> apples2 = new ArrayList<Apple>();   //It's ok
        List<Fruit> fruits = new ArrayList<Fruit>();    //It's ok too

        //Example of covariant generics
        List<? extends Fruit> apples3 = new ArrayList<Apple>(); //It's ok

        // Compile Error: can’t add any type of object:
        // apples3.add(new Apple());
        // apples3.add(new Fruit());
        // apples3.add(new Object());
        // apples3.<Apple>add(new Apple());
        // apples3.<Fruit>add(new Fruit());

        apples3.add(null); // Legal but uninteresting
        // We know that it returns at least Fruit:
        Fruit f = apples3.get(0);
        apples3.contains(new Apple());
        apples3.indexOf(new Fruit());
        // ups.... why?...
        // So, we can only get data from such a list.
        // And data will be upcasted to upper bount Fruit

        // How smart is compiler?
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0); // No warning
        flist.contains(new Apple()); // Argument is ‘Object’
        flist.indexOf(new Apple()); // Argument is ‘Object’

    }
}
