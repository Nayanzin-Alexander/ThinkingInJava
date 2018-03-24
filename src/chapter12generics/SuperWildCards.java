package chapter12generics;

import java.util.List;

/**
 * Created by nayanzin on 17.07.17.
 */
public class SuperWildCards {
    static void write(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan()); //emmmmm.....
        //emmmmmmmmm...............
        //emmmmmmmmmmmm...................................
        // apples.add(new Fruit()); // Error
    }

    static void writeAnother(List<? extends Fruit> fruits){
        // fruits.add(new Apple()); // Error
        // fruits.add(new Jonathan()); // Error
        // fruits.add(new Fruit()); // Error
    }
}
