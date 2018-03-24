package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 30.06.17.
 */

interface Incrementable{
    void increment();
}

// Very simple to just implement Incrementable:
class Callee1 implements Incrementable{
    private int i = 0;
    @Override
    public void increment() {
        i++;
        print("Callee1.i " + i);
    }
}

class MyIncrement{
    public void increment(){
        print("MyIncrement.increment()");
    }
    public static void f(MyIncrement myIncrement){
        print("inside MyIncrement.f()");
        myIncrement.increment();
    }
}

// If your class must implement increment() in
// some other way, you must use an inner class:
class Callee2 extends MyIncrement{
    private int i =0;
    public void  increment(){
        super.increment();
        i++;
        print("Callee2.i " + i);
    }

    private class Closure implements Incrementable{
        @Override
        public void increment() {
            // Specify outer-class method, otherwise
            // you’d get an infinite recursion:
            print("Inside closure)");
            Callee2.this.increment();
        }
    }

    public Incrementable getIncrementable(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callBackReference;

    public Caller(Incrementable callBackReference){
        this.callBackReference = callBackReference;
    }

    public void go(){
        callBackReference.increment();
    }
}

public class Callbacks {
    public static void main(String... args){
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();

        MyIncrement.f(callee2);

        Caller caller1 = new Caller(callee1);
        Caller caller2 = new Caller(callee2.getIncrementable());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
