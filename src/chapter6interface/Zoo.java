package chapter6interface;

/**
 * Created by nayanzin on 28.06.17.
 */
public class Zoo {
    static int zooCapacity = 10;
    static int getZooCapacity(){
        return zooCapacity;
    }
    void increasePopulation(Creature creature){
        creature.born();
        creature.yell();
    }

    void startFlyingShow(Flyable flyable){
        flyable.fly();
        flyable.yell();
        flyable.land();
    }

    void startSwimmingShow(Swimable swimable){
        swimable.swim();
        swimable.yell();
        swimable.goToShore();
    }

    public static void main(String... args){
        Zoo myZoo = new Zoo();
        BirdInterface DonaldDuck = new Duck();

        myZoo.increasePopulation(DonaldDuck);
        myZoo.startFlyingShow(DonaldDuck);
        myZoo.startSwimmingShow(DonaldDuck);
    }
}
