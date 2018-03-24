package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 02.07.17.
 */

class WhithInner{
    int i = 10;

    public void increment(){
        i++;
    }
    class Inner{
        public void f(){
            print("Inner.i= "+i);
        }
    }
}

public class InheritInner extends WhithInner.Inner {
    public InheritInner(WhithInner whithInner){
        whithInner.super();
    }

    public static void main(String... args){
        WhithInner wi = new WhithInner();
        wi.increment();
        wi.increment();
        wi.increment();

        InheritInner ii = new InheritInner(wi);
        ii.f();
    }
}
