package chapter2operators;
//Solutions to selected exercises can be found in the electronic document The Thinking in Java Annotated Solution Guide,
//available for sale from www.MindView.net.
/**
 * Created by nayanzin on 22.06.17.
 * vampire number has an even number of digits and is formed by
 * multiplying a pair of numbers containing half the number of digits of the result.
 * The digits are taken from the original number in any order.
 * Pairs of trailing zeroes are not allowed.
 *  Examples include:
 *  1260 = 21 * 60
 *  1827 = 21 * 87
 *  2187 = 27 * 81
 *  Write a program that finds all the 4-digit vampire numbers.
 *                                  (Suggested by Dan Forhan.)
 */
public class FourDigitsVampireNumbers {

    private static boolean isEvilNumber(int number){
        // We use 4 digits integer.
        // 1. parse number

        String n1Char = ( (Character) ( (Integer) number).toString().charAt(0)).toString();
        String n2Char = ( (Character) ( (Integer) number).toString().charAt(1)).toString();
        String n3Char = ( (Character) ( (Integer) number).toString().charAt(2)).toString();
        String n4Char = ( (Character) ( (Integer) number).toString().charAt(3)).toString();

        int comb1 = Integer.parseInt(n1Char + n2Char);
        int comb2 = Integer.parseInt(n1Char + n3Char);
        int comb3 = Integer.parseInt(n1Char + n4Char);
        int comb4 = Integer.parseInt(n2Char + n3Char);
        int comb5 = Integer.parseInt(n2Char + n4Char);
        int comb6 = Integer.parseInt(n3Char + n4Char);

        if((comb1 * comb2) == number)
            return true;
        if((comb1 * comb3) == number)
            return true;
        if((comb1 * comb4) == number)
            return true;
        if((comb1 * comb5) == number)
            return true;
        if((comb1 * comb6) == number)
            return true;
        if((comb2 * comb3) == number)
            return true;
        if((comb2 * comb4) == number)
            return true;
        if((comb2 * comb5) == number)
            return true;
        if((comb2 * comb6) == number)
            return true;
        if((comb3 * comb4) == number)
            return true;
        if((comb3 * comb5) == number)
            return true;
        if((comb3 * comb6) == number)
            return true;
        if((comb4 * comb5) == number)
            return true;
        if((comb4 * comb6) == number)
            return true;
        if((comb5 * comb6) == number)
            return true;
        return false;
    }

    public static void main(String[] args){
        for(int i=1000; i<10000; i++){
            if(isEvilNumber(i)){
                System.out.println(i);
            }
        }
    }
}
