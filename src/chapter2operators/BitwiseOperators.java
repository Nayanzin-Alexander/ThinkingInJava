package chapter2operators;

/**
 * Created by nayanzin on 22.06.17.
 */
public class BitwiseOperators {
    private static void printBinary(String msg, int value){
        System.out.println("operation: "+msg);
        System.out.println("value=" + value + " binary=" + Integer.toBinaryString(value));
        System.out.println("");
    }

    public static void main(String[] args){
        int i = 100;
        int j = 0;
        printBinary("i=100", i);

        i <<= 2;
        printBinary("i <<= 2", i);

        i >>= 2;
        printBinary("i >>= 2", i);

        i = ~i;
        printBinary("i = ~i", i);

        i = -i;
        printBinary("i = -i", i);

        i = 5;
        j = -5;
        printBinary("i = 5", i);
        printBinary("j = -5", j);

        printBinary("i & j", i & j);
        printBinary("i | j", i | j);
        printBinary("i ^ j", i ^ j);

        short short1 = 1;
        short short2 = 2;
        printBinary("short1 + short2", short1 + short2);



    }
}
