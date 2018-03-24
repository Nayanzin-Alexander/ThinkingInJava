package chapter7innerclasses;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.06.17.
 */

interface Game {
    int NUMBER_OF_GAMES = 10;
    boolean move();
    class NumberCounter{
        private static int gamesCount;
        public NumberCounter(){
            print("Inside NumberCounter constructor");
        }
        public static void incrementGamesCount(){
            print("Inside NumberCounter incrementGamesCount");
            gamesCount++;
        }
        public static void decrementGamesCount(){
            print("Inside NumberCounter decrementGamesCount");
            gamesCount--;
        }
        public static int getGamesCount(){
            print("Inside NumberCounter getGamesCount");
            return gamesCount;
        }
    }
}

interface GameFactory   {   Game create();  }

class Checkers implements Game {
    public static GameFactory checkersFactory = new GameFactory(){
            @Override
            public Game create(){
                Game.NumberCounter.incrementGamesCount();
                return new Checkers();
            }
        };
    private int moves;
    private static final int MOVES = 3;

    @Override
    public boolean move(){
        print("Checkers move " + moves);
        return ++moves != MOVES;
    }
}

class Chess implements Game {
    public static GameFactory chessFactory = new GameFactory(){
            @Override
            public Game create(){
                Game.NumberCounter.incrementGamesCount();
                return new Chess();
            };
        };
    private int moves;
    private static final int MOVES = 4;

    @Override
    public boolean move(){
        print("Chess move " + moves);
        return ++moves != MOVES;
    }
}

class CoinTossing implements Game {
    public static GameFactory coinTossingFactory = new GameFactory(){
            @Override
            public Game create() {
                Game.NumberCounter.incrementGamesCount();
                return new CoinTossing();
            }
        };
    private int moves;
    private final int MOVES = 3;

    @Override
    public boolean move(){
        print("Coin tossined");
        return ++moves != MOVES;
    }
}

class DiceTossing implements Game {
    public static GameFactory diceTossingFactory = new GameFactory(){
            @Override
            public Game create(){
                Game.NumberCounter.incrementGamesCount();
                return new DiceTossing();
            }
        };
    private int moves;
    private final int MOVES = 2;

    @Override
    public boolean move(){
        print("Dice tossined");
        return ++moves != MOVES;
    }
}



public class Games {

    public static void play(GameFactory gameFactory){
        Game game = gameFactory.create();
        while(game.move());
    }

    public static void main(String... args){
        play(Chess.chessFactory);
        play(Checkers.checkersFactory);
        play(CoinTossing.coinTossingFactory);
        play(DiceTossing.diceTossingFactory);
        print(Game.NumberCounter.getGamesCount());
    }
}
