package chapter6interface;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 28.06.17.
 */

interface Game          {   boolean move();    }
interface GameFactory   {   Game create();  }

class Checkers implements Game{
    private int moves;
    private static final int MOVES = 3;
    @Override
    public boolean move(){
        print("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class CheckersFactory implements GameFactory{
    @Override
    public Game create(){
        return new Checkers();
    }
}

class Chess implements Game{
    private int moves;
    private static final int MOVES = 4;
    @Override
    public boolean move(){
        print("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class ChessFactory implements GameFactory{
    @Override
    public Game create(){
        return new Chess();
    }
}

class CoinTossing implements Game{
    private int moves;
    private final int MOVES = 3;

    @Override
    public boolean move(){
        print("Coin tossined");
        return ++moves != MOVES;
    }
}

class CoinTossingFactory implements GameFactory{
    @Override
    public Game create(){
        return new CoinTossing();
    }
}

class DiceTossing implements Game{
    private int moves;
    private final int MOVES = 2;

    @Override
    public boolean move(){
        print("Dice tossined");
        return ++moves != MOVES;
    }
}

class DiceTossingFactory implements GameFactory{
    @Override
    public Game create(){
        return new DiceTossing();
    }
}

public class Games {

    public static void play(GameFactory gameFactory){
        Game game = gameFactory.create();
        while(game.move());
    }

    public static void main(String... args){
        play(new ChessFactory());
        play(new CheckersFactory());
        play(new CoinTossingFactory());
        play(new DiceTossingFactory());
    }
}
