package chapter11typeinformation;

import static myutil.ClassInfo.printClass;
import static myutil.Printer.print;

/**
 * Created by nayanzin on 10.07.17.
 */

class Toy{}
class FancyToy extends Toy{}

public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Toy fancyToy = new FancyToy();
        print( (FancyToy) fancyToy);
        print(FancyToy.class.cast(fancyToy));
        Class<? extends Object> cl = FancyToy.class;
        Object ft = cl.newInstance();
        ft = FancyToy.class.cast(ft);
        ft = cl.cast(ft);
    }
}
