package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 29.06.17.
 */

public class NestedVsInner {

    public NestedVsInner(){
        print("NestedVsInner constructor");
    }

    public class Inner{
        public Inner(){
            print("Inner constructor");
        }
        public void tryIt(){
            print("Inner tryIt()");
        }
    }

    public static class Nested {
        public Nested(){
            print("Nested constructor");
        }
        public void tryIt(){
            print("Nested tryIt()");
        }
    }

    public static Nested getNestedClass(){
        return new Nested();
    }

    /* Can't do this, because inner class need base class to be created
    public static Inner getInnerClass(){
        return new Inner();
    }
    */

    public static void main(String... args){

        print("Trying to use Nested class");
        NestedVsInner.getNestedClass().tryIt();

        //How can I directly create Nested
        new NestedVsInner.Nested().tryIt();
        //Here is the way

        print("Trying to use Inner class");
        new NestedVsInner().new Inner().tryIt();


    }
}
