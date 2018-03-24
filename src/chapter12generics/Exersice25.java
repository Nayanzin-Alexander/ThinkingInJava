package chapter12generics;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 17.07.17.
 * Exercise 25: (2) Create two interfaces and a class that implements both. Create two
 * generic methods, one whose argument parameter is bounded by the first interface and one
 * whose argument parameter is bounded by the second interface. Create an instance of the
 * class that implements both interfaces, and show that it can be used with both generic
 * methods.
 */

interface Swimable{
    void swim();
}

interface Flyable{
    void fly();
}

class Duck implements Swimable, Flyable{
    public void swim(){
        print("Swim");
    }
    public void fly(){
        print("Fly");
    }
}

class RealWorld{
    public static <T extends Swimable> void swim(T creature){
        creature.swim();
    }

    public static <T extends Flyable> void fly(T creature){
        creature.fly();
    }

    public static <T extends Swimable & Flyable> void throwToTheRiver(T creature){
        creature.fly();
        creature.swim();
    }
}

public class Exersice25 {
    public static void main(String... args){
        Duck donald = new Duck();
        RealWorld.swim(donald);
        RealWorld.fly(donald);
        RealWorld.throwToTheRiver(donald);
    }
}
