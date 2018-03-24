package chapter14containersindepth.perfomancetestframework;

/**
 * Created by nayanzin on 31.07.17.
 */
public abstract class Test<C> {
    String name;
    public Test(String name) {this.name = name;}
    // Override this method for different tests
    // Returns actual number of repetitions of test.
    protected abstract int test(C container, TestParam tp);
}
