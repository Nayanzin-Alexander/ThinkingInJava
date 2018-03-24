package chapter16enum.roshambo;

import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 18.08.17.
 */
interface Item {
    Random rand = new Random(47);
    Outcome treat(Item second);

    static Item generate(){
        switch(rand.nextInt(3)) {
            case 0: return new Stone();
            case 1: return new Scissors();
            default: return new Paper();
        }
    }
}

class Stone implements Item {
    public Outcome treat(Item second){
        Class secondClass = second.getClass();
        if(secondClass == Stone.class)
            return Outcome.DRAW;
        else if(secondClass == Scissors.class)
            return Outcome.WIN;
        return Outcome.LOSE;
    }
    @Override
    public String toString(){
        return "Stone";
    }
}

class Scissors implements Item {
    public Outcome treat(Item second){
        Class secondClass = second.getClass();
        if(secondClass == Stone.class)
            return Outcome.LOSE;
        else if(secondClass == Scissors.class)
            return Outcome.DRAW;
        return Outcome.WIN;
    }
    @Override
    public String toString(){
        return "Scissors";
    }
}

class Paper  implements Item {
    public Outcome treat(Item second){
        Class secondClass = second.getClass();
        if(secondClass == Stone.class)
            return Outcome.WIN;
        else if(secondClass == Scissors.class)
            return Outcome.LOSE;
        return Outcome.DRAW;
    }
    @Override
    public String toString(){
        return "Paper";
    }
}

public class RoShamBo1 {
    public static void main(String... args) {
        for (int i=0; i<10; i++){
            Item item1 = Item.generate();
            Item item2 = Item.generate();
            print(item1 + " vs " + item2 + " " + item1.treat(item2));
        }
    }
}
