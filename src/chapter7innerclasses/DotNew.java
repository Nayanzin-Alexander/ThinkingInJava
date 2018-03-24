package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 29.06.17.
 */
public class DotNew {
    private int i = 10;
    class Inner{
        Inner(){
            print(i);
        }
    }

    public static void main(String... args){
        Inner in = new DotNew().new Inner();
    }
}
