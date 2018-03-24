package chapter2operators;

/**
 * Created by nayanzin on 21.06.17.
 */
public class Literals {
    public static void main(String[] args){
        int i1 = 0x2f; // Hexadecimal (lowercase)
        System.out.println("i1 = " + Integer.toBinaryString(i1));

        int i2 = 0X2F; // Hexadecimal (uppercase)
        System.out.println("i2 = " + Integer.toBinaryString(i2));

        int i3 = 0177; // Octal (leading zero)
        System.out.println("i3 = " + Integer.toBinaryString(i3));

        char c = 0xffff; // max char hex value
        System.out.println("c = " + Integer.toBinaryString(c));

        byte    b = 0x7f;   // max byte hex value
        short   s = 0x7fff; // max short hex value
        long    n1 = 200L;  // long suffix
        long    n2 = 200l;  // long suffix (but can be confusing)
        long    n3 = 200;   // no suffix
        float   f1 = 1;     // no suffix
        float   f2 = 1F;    // float suffix
        float   f3 = 1f;    // float suffix
        double  d1 = 1d;    // double suffix
        double  d2 = 1D;    // double suffix
        // (Hex and Octal also work with long)

        System.out.println("Max double is " +1.7e308);
        System.out.println("Max float is " +3.4e38f);
        System.out.println("Min double is " +(-1.7e308));
        System.out.println("Min float is " +(-3.4e38f));
    }
}
