package chapter3accesscontrol;

import static myutil.Printer.*;
import static myutil.Range.*;

/**
 * Created by nayanzin on 23.06.17.
 */
public class PrintTest {
    public static void main(String... args){
       print();
        print(123);
        print(123,'a', "sss");
        int[] array = {1,2,3,4,5};
        print(array);

        for(int i:range(5,11,3)){
            print(i);
        }
    }
}
