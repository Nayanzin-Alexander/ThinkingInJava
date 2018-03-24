package chapter12generics;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 16.07.17.
 */

class Base{}
class Sub extends Base{};

public class MyIsInstance {
    public static boolean myIsInstance(Class<?> cl, Object obj){
        try{
            cl.cast(obj);
            return true;
        }catch(ClassCastException e){
            return false;
        }
    }

    public static void main(String... args){
        print(myIsInstance(Base.class, new Sub())); // must be true
        print(myIsInstance(Base.class, new Base())); // must be true
        print(myIsInstance(Sub.class, new Sub())); // must be true
        print(myIsInstance(Sub.class, new Base())); // must be false
    }
}
