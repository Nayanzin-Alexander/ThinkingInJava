package myutil;

/**
 * Created by nayanzin on 23.06.17.
 * Produces a sequence
 */

public class Range {
    /**
     * Produce a sequence (0..n) incrementing by 1
     * @param n last number in a sequence
     * @return return a sequence (0..n)
     */
    public static int[] range(int n){
        int[] result = new int[n];
        for(int i = 0; i < n; i++)
            result[i] = i;
        return result;
    }

    /**
     * Produce a sequence (start..stop) incrementing by 1
     * @param start first number in a sequence
     * @param stop last number in sequence
     * @return return a sequence (start..stop)
     */
    public static int[] range(int start, int stop){
        int size = stop - start;
        int[] result = new int[size];
        for(int i = 0; i < size; i++)
            result[i] = start + i;
        return result;
    }

    /**
     * Produce a sequence (start..stop) incrementing by step
     * @param start first number in a sequence
     * @param stop upper border in sequence
     * @param step incrementing sequence
     * @return return a sequence (start..stop)
     */
    public static int[] range(int start, int stop, int step){
        int size = (stop - start) / step + 1;
        int[] result = new int[size];
        for(int i = 0; i < size; i++)
            result[i] = start + (i * step);
        return result;
    }
}
