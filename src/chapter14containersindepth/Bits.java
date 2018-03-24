package chapter14containersindepth;

import java.util.BitSet;
import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 02.08.17.
 */
public class Bits {
    public static void printBitSet(BitSet b) {
        print("bits: " + b);
        StringBuilder bbits = new StringBuilder();
        for(int j = 0; j < b.size(); j++){
            bbits.append((b.get(j) ? "1" : "0"));
        }
        print("bit pattern: " + bbits);
    }

    public static void main(String... args){
        Random rand = new Random(47);
        byte bt = (byte) rand.nextInt();
        BitSet bb = new BitSet();
        for(int i = 7; i >=0; i--)
            if( ( (1 << i) & bt) != 0)
                bb.set(i);
            else
                bb.clear(i);
        print("byte value: " + bt);
        printBitSet(bb);

        short st = (short)rand.nextInt();
        BitSet bs = new BitSet();
        for(int i = 15; i >= 0; i--)
            if(((1 << i) & st) != 0)
                bs.set(i);
            else
                bs.clear(i);
        print("short value: " + st);
        printBitSet(bs);
        int it = rand.nextInt();
        BitSet bi = new BitSet();
        for(int i = 31; i >= 0; i--)
            if(((1 << i) & it) != 0)
                bi.set(i);
            else
                bi.clear(i);
        print("int value: " + it);
        printBitSet(bi);
    }

}
