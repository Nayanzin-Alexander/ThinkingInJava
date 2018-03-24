package chapter7innerclasses;

import static myutil.Printer.*;
/**
 * Created by nayanzin on 29.06.17.
 */
public class DotThis {

    class Inner{
        DotThis getDotThis(){
            return DotThis.this;
        }
    }
    private int i = 55;
    void f(){   print("DotThis"); }
    Inner getInner(){
        print("private field of outer class is " + i);
        return new Inner();
    }

    public static void main(String... args){
        DotThis dotThis = new DotThis();
        dotThis.getInner().getDotThis().f();
    }


}
