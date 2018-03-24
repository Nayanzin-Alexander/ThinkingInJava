package chapter9exceptions;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 04.07.17.
 */
public class FinallyTry {
    public static int f(){
        int i=10;
        try{
            return i;
        }
        finally{
            i = 20;
            print("I am in finally, Boss...but i returns with value 10...");
        }
    }

    public static void main(String... args){
        print(f());
    }
}
