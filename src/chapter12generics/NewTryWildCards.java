package chapter12generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nayanzin on 17.07.17.
 */

class Base1{
    public void base(){};
}
class Derived1 extends Base1{
    public void derived(){}
}
public class NewTryWildCards {
    public static void main(String... args) {
        List<? extends Base1> l1 = new ArrayList<Derived1>();
        //! l1.add(new Derived1()); // Error
        //! l1.add(new Base1()); // Error
        // What if we try this:
        //! List<? extends Derived1> l0 = new ArrayList<Base1>(); //Error

        List<? super Derived1> l2 = new ArrayList<Base1>();
        l2.add(new Derived1());
        //! l2.add(new Base1()); // Error
        // So <? super T> means that we can use only T and derrived form T.\
        List<? super Base1> l3 = new ArrayList<Base1>();
        l3.add(new Derived1());
        l3.add(new Base1());

        // Looks like <? super Base> and <? extends Base> means specific type
        // means Base or derived from Base. But we can use that type in different ways
    }
}
