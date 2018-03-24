package chapter14containersindepth.perfomancetestframework;

/**
 * Created by nayanzin on 31.07.17.
 */
public interface Testable <C> {
    int test(C collection, TestParam tp);
}
