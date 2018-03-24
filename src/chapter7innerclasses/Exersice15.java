package chapter7innerclasses;

/**
 * Created by nayanzin on 29.06.17.
 * Exercise 15: (2) Create a class with a non-default constructor (one with arguments) and
 * no default constructor (no "no-arg" constructor). Create a second class that has a method
 * that returns a reference to an object of the first class. Create the object that you return by
 * making an anonymous inner class that inherits from the first class.
 */

class FirstClass{
    private int value;

    public FirstClass(int value){
       this.value = value;
    }

    public FirstClass(){
        this.value = 15;
    }

    public int getValue(){
        return value;
    }
}

public class Exersice15 {

    public static FirstClass createFirstClassInstatnce(int value){
        return new FirstClass(value){
        };
    }

    public static FirstClass createFirstClassInstatnce(){
        return new FirstClass(){
        };
    }
}
