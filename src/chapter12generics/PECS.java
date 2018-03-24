package chapter12generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 18.07.17.
 */

public class PECS {
    static double f(List<? extends Number>... lists){
        double result = 0;
        int notNullElementsCounter = 0;
        for(List<? extends Number> list : lists) {
            for (Number num : list) {
                result += num.doubleValue();
                notNullElementsCounter++;
            }
        }
        notNullElementsCounter = notNullElementsCounter > 0
                ? notNullElementsCounter
                : 1;
        result = result / notNullElementsCounter;
        return result;
    }
    static <T> void copy(List<? super T> dest, List<? extends T> source){
        for(int i=0; i < source.size(); i++){
            dest.set(i, source.get(i));
        }
    }

    public static void main(String... args){
        List<Integer> integers = Arrays.asList(new Integer[]{1,2,3});
        List<Double> doubles = Arrays.asList(new Double[]{4D,2D,3.03});
        List<Long> longs = Arrays.asList(new Long[]{4L,2L,3L});
        double result = f(integers, doubles, longs);
        print(result);
    }

}
