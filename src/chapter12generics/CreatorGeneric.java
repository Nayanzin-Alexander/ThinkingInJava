package chapter12generics;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 16.07.17.
 */

abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate(){
        element = create();
    }
    abstract T create();
}

class X{}

class Creator extends GenericWithCreate<X>{
    X create(){
        return new X();
    }
    void f(){
        print(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String... args){
        Creator c = new Creator();
        c.f();
    }
}
