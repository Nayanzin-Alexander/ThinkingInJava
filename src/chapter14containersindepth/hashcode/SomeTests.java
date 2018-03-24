package chapter14containersindepth.hashcode;

import java.util.ArrayList;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 30.07.17.
 */

class ClassA{
    public Integer i;
    @Override
    public String toString(){
        return i.toString();
    }
}

public class SomeTests {
    public static void main(String... args){
        Integer int1 = 5;
        Integer int2 = int1;
        print(int1);
        print(int2);
        int1 = 3; // equivalent int1 = new Integer(3); ... int1 repoints to another object
        print(int1);
        print(int2);
    }
}
