package chapter6interface;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 28.06.17.
 */
public class Duck implements BirdInterface {

    private static int numberOfDuck = 0;

    @Override
    public void born() {
        if( numberOfDuck < Creature.MAX_NUMBER_OF_CREATURES){
            numberOfDuck++;
            print("Duck has born.");
        } else {
            print("There are a lot of ducks");
        }

    }

    @Override
    public void die() {
        print("Duck has die.");
    }

    @Override
    public void fly() {
        print("Duck trying to fly... Yes it can fly!!!");
    }

    @Override
    public void land() {
        print("Duck is landing");
    }

    @Override
    public void swim() {
        print("Duck is swiming");
    }

    @Override
    public void goToShore() {
        print("Duck goes to the shore");
    }

    @Override
    public void yell() {
        print("Duck is yelling. Somebody feed the duck");
    }
}
