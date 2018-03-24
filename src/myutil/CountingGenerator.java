package myutil;

import chapter12generics.Generator;

import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.07.17.
 */
public class CountingGenerator {

    public static class Boolean implements Generator<java.lang.Boolean>{
        private boolean value = false;
        public java.lang.Boolean next(){
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte>{
        private byte value = 0;
        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
    "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements Generator<java.lang.Character>{
        private Random rand = new Random(50);
        public java.lang.Character next(){
            return chars[rand.nextInt(chars.length)];
        }
    }

    public static class String implements Generator<java.lang.String>{
        private int length = 7;
        public String(){}
        public String(int length){
            this.length = length;
        }
        Generator<java.lang.Character> characterGenerator = new Character();

        public java.lang.String next(){
            char[] chars = new char[length];
            for(int i = 0; i < length; i++){
                chars[i] = characterGenerator.next();
            }
            return new java.lang.String(chars);
        }
    }

    public static class Short implements Generator<java.lang.Short> {
        private short value = 0;
        public java.lang.Short next() { return value++; }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        private int value = 0;
        public java.lang.Integer next() { return value++; }
    }

    public static class Long implements Generator<java.lang.Long> {
        private long value = 0;
        public java.lang.Long next() { return value++; }
    }

    public static class Float implements Generator<java.lang.Float> {
        private float value = 0;
        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
    }

    public static class Double implements Generator<java.lang.Double>   {
        private double value = 0.0;
        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }

    public static class BigDecimal implements Generator<java.math.BigDecimal>{
        java.math.BigDecimal value = new java.math.BigDecimal(100);
        public java.math.BigDecimal next(){
            value = value.add(new java.math.BigDecimal(1));
            return value;
        }
    }
}
