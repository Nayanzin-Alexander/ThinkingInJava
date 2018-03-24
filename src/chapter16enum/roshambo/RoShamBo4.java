package chapter16enum.roshambo;

/**
 * Created by nayanzin on 20.08.17.
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {
        ROCK {
            public Outcome compete(RoShamBo4 opponent) {
                return compete(SCISSORS, opponent);
            }
        },
        SCISSORS {
            public Outcome compete(RoShamBo4 opponent) {
                return compete(PAPER, opponent);
            }
        },
        PAPER {
            public Outcome compete(RoShamBo4 opponent) {
                return compete(ROCK, opponent);
            }
        };
    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return ((opponent == this) ? Outcome.DRAW
                : ((opponent == loser) ? Outcome.WIN
                : Outcome.LOSE));
    }

    @Override
    public Outcome compete(RoShamBo4 competitor) {
        return null;
    }
}
