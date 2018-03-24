package chapter18concurrency.sharedresources;

import static myutil.Printer.print;
import static sun.misc.GThreadHelper.lock;
import static sun.misc.GThreadHelper.unlock;

/**
 * Created by nayanzin on 01.09.17.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    @Override
    public  int next() {

        try{
            //lock();
            ++currentEvenValue; // Danger point here!
            ++currentEvenValue;
            //unlock();
        } catch (Exception e) {
            print("Interrupted");
        }

        return currentEvenValue;
    }
    public static void main(String... args) {
        EvenChecker.test(new EvenGenerator());
    }
}
