package chapter16enum.roshambo;

import static chapter16enum.roshambo.Outcome.*;


/**
 * Created by nayanzin on 20.08.17.
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER {
        public Outcome compete(RoShamBo3 it) {
            switch(it) {
                default:
                case PAPER: return DRAW;
                case SCISSORS: return LOSE;
                case ROCK: return WIN;
            }
        }
    },SCISSORS {
        public Outcome compete(RoShamBo3 it) {
            switch(it) {
                default:
                case PAPER: return WIN;
                case SCISSORS: return DRAW;
                case ROCK: return LOSE;
            }
        }
    },ROCK {
        public Outcome compete(RoShamBo3 it) {
            switch(it) {
                default:
                case PAPER: return LOSE;
                case SCISSORS: return WIN;
                case ROCK: return DRAW;
            }
        }
    };

    @Override
    public Outcome compete(RoShamBo3 competitor) {
        return null;
    }

    public static void main(String... args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
