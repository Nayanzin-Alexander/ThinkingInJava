package chapter7innerclasses;

import java.util.Random;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 30.06.17.
 * Exercise 23: (4)
 *
 * Create an interface U with three methods.
 *
 * Create a class A with a method that produces a reference to a U by building an
 *  anonymous inner class.
 *
 *  Create a second class B that contains an array of U.
 *      B should have one method that accepts and stores a reference
 *      to a U in the array, a second method that sets a reference in
 *      the array (specified by the method argument) to null,
 *      and a third method that moves through the array and calls
 *      the methods in U.
 *
 *  In main( ), create a group of A objects and a single B. Fill the B with U
 *      references produced by the A objects. Use the B to call back into all
 *      the A objects. Remove some of the U references from the B.
 */

interface U{
    void method1();
    void method2();
    void method3();
}

class A{
    public static U uFactory(){
        return new U(){
            public void method1(){print("method1");};
            public void method2(){print("method2");};
            public void method3(){print("method3");};
        };
    }
}

class B{
    private U[] uArray;
    public int length;
    private int lastElement = 0;

    public B(int arraySize){
        length = arraySize > 0 ? arraySize : 0;
        uArray = new U[length];
    }

    public void acceptU(U u){
        uArray[lastElement++] = u;
    }

    public void setNullByIndex(int index){
        if(index < uArray.length){
            uArray[index] = null;
        }
    }

    public void walkThroughUArray(){
        int i = 0;
        for(U u:uArray){
            i++;
            if(u != null){
                print("Calling " + i);
                u.method1();
                u.method2();
                u.method3();
            } else {
                print(i + " is null");
            }
        }
    }
}

public class Exersice23 {
    public static void main(String... args){
        B b = new B(10);
        for(int i=0; i < b.length; i++){
            b.acceptU(A.uFactory());
        }

        b.walkThroughUArray();

        Random rand = new Random(55);
        b.setNullByIndex(rand.nextInt(b.length));
        b.setNullByIndex(rand.nextInt(b.length));
        b.setNullByIndex(rand.nextInt(b.length));

        b.walkThroughUArray();
    }
}
