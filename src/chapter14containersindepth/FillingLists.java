package chapter14containersindepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 26.07.17.
 */

class A{
    private static long count = 0;
    private final long ID = count++;


    @Override
    public String toString(){
        return super.toString() + " " + ID ;
    }
}

public class FillingLists {
    public static void main(String... args){
        List<A> list = new ArrayList<>(Collections.nCopies(10, new A()));
        print(list);
        Collections.fill(list, new A());
        print(list);
    }
}
