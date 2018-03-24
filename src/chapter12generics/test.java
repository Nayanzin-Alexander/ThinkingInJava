package chapter12generics;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 13.07.17.
 */

class Pet implements Comparable<Pet>{
    @Override
    public int compareTo(Pet o) {
        return 0;
    }
}

class Cat extends Pet implements Comparable<Pet>{

}
public class test {
    public static void main(String... args){
        Fibonacci f = new Fibonacci();
        for(int i=0; i < 10; i++){
            //print(f.next());
        }

        for(int number : f.getIterable(10)){
            print(number);
        }
    }
}
