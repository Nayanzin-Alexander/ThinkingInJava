package chapter13arraysindepth;

import java.util.Arrays;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.07.17.
 */
public class ComparingArrays {
    public static void main(String[] args) {
// Demonstrate deep Equals
        int[][][] matrix1 = {
                {{1},{2},{3}},
                {{1},{2}}
        };

        int[][][] matrix2 = {
                {{1},{2},{3}},
                {{1},{2}}
        };

        print(Arrays.deepEquals(matrix1, matrix2));
    }
}
