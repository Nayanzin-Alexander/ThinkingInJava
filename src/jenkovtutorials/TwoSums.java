package jenkovtutorials;

/**
 * Created by nayanzin on 12.09.17.
 */
public class TwoSums {
    private int sum1 = 0;
    private int sum2 = 0;

    private Integer sumLock1 = new Integer(1);
    private Integer sumLock2 = new Integer(2);

    public void add(int val1, int val2) {
        synchronized (this.sumLock1) {
            this.sum1 += val1;
        }
        synchronized (this.sumLock2) {
            this.sum2 += val2;
        }
    }
}
