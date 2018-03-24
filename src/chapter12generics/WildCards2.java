package chapter12generics;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 19.07.17.
 */

class H<T>{
    public String toString(){
        return this.getClass().getName().toString();
    }
}

public class WildCards2 {
    static <T> void raw(H t){
        print(t.getClass().getName());
        whithT(t);
    }

    static <T> void whithT(H<T> t){
        print(t.getClass().getName());
    }

    public static void main(String... args){
        raw(new H());
        whithT(new H());
    }
}
