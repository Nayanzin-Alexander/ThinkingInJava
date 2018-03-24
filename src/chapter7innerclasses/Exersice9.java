package chapter7innerclasses;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 29.06.17.
 */

interface ForInnerInterface{
    void testInner(int i);
}

public class Exersice9 {
    public ForInnerInterface getInnerFromMethod(){
        int i = 10;
        if(i==10) {
            class Inner implements ForInnerInterface {
                private int j;
                Inner(int j){
                    this.j = j;
                }
                public void testInner(int i) {
                    print("Testing inner " + i+j);
                }
            }

            return new Inner(i);
        }
        // here is anonymous class.
        // Or implementation of interface
        return new ForInnerInterface(){
            public void testInner(int i) {
                print("Testing anonymous inner class " + i);
            }
        };
    }

    public static void main(String... args){
        new Exersice9().getInnerFromMethod().testInner(10);
    }
}
