package chapter16enum.roshambo;

/**
 * Created by nayanzin on 20.08.17.
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
