package chapter7innerclasses;

import static myutil.Printer.*;
/**
 * Created by nayanzin on 29.06.17.
 */

abstract class Base {
    public Base(int i) {
        print("Base constructor, i = " + i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
    Base getBase(int i){
        return new Base(i){
            {
                print("Looks like a anonymous constructor");
            }

            @Override
            public void f(){
                print("Calling f()");
            }
        };
    }

    public static void main(String... args){
        AnonymousConstructor ac = new AnonymousConstructor();
        Base base = ac.getBase(10);
        base.f();
    }
}
