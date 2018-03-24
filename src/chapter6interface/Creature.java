package chapter6interface;


/**
 * Created by nayanzin on 28.06.17.
 */
public interface Creature {
    int MAX_NUMBER_OF_CREATURES = Zoo.getZooCapacity();
    void born();
    void yell();
    void die();
}

interface Flyable {
    void fly();
    void yell();
    void land();
}

interface Swimable {
    void swim();
    void yell();
    void goToShore();
}

interface BirdInterface extends Creature,
        Flyable, Swimable{
    void yell();
}
