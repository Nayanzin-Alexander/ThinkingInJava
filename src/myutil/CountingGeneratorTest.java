package myutil;

import chapter12generics.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.07.17.
 */
public class CountingGeneratorTest {

    public static int size = 10;

    public static void test(Class<?> surroundingClass){
        for(Class<?> type : surroundingClass.getClasses()){
            print("");
            print(type.getSimpleName());
            try{
                Generator<?> generator = (Generator<?>) type.newInstance();
                StringBuffer sb = new StringBuffer("{ ");

                for(int i=0; i < size; i++){
                    sb.append(generator.next());
                    if(i != (size - 1))
                        sb.append(" , ");
                }
                sb.append(" }");
                print(sb);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        //test(CountingGenerator.class);
        //test(RandomGenerator.class);

        //testing Generated
        Integer[] Integers = Generated.array(Integer.class, new RandomGenerator.Integer(), 50);
        print(Integers);

        // converting to primitives test
        int[] integers = new int[Integers.length];
        for(int i=0; i< Integers.length; i++)
            integers[i] = Integers[i];
        print(Arrays.toString(integers));

        BigDecimal[] decimals = Generated.array(BigDecimal.class, new CountingGenerator.BigDecimal(), 10);
        print(decimals);

    }
}
