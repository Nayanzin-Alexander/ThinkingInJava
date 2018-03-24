package chapter6interface;

/**
 * Created by nayanzin on 28.06.17.
 */
public interface Monster {
    void menace();
}

interface DangerousMonster extends Monster{
    void destroy();
}

interface Lethal{
    void kill();
}

class DragonZilla implements DangerousMonster{
    public void menace(){}
    public void destroy(){}
}

interface Vampire extends DangerousMonster, Lethal{
    void drinkBlood();
}

class VeryBadVampire implements Vampire{
    public void menace() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}

