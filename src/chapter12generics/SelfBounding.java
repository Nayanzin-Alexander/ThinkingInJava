package chapter12generics;

/**
 * Created by nayanzin on 19.07.17.
 */

class SelfBounded<T extends SelfBounded<T>>{
    T element;
    SelfBounded <T> set(T arg){
        element = arg;
        return this;
    }
    T get(){
        return element;
    }
}

class A extends SelfBounded<A>{}

class B extends SelfBounded<A>{}

class C extends SelfBounded<C>{
    C setAndGet(C arg){
        element = arg;
        return get();
    }
}

class D{}

//! class E extends SelfBounded<D>{} // Type parameter D is not within its bound

class F extends SelfBounded{}


public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());

        a.set(new A().get());
        a = a.get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}
