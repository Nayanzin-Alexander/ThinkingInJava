package myutil;


import java.util.Map;

/**
 * Created by nayanzin on 23.06.17.
 */
public class Printer {
    public static void print(Object... args){
        for(Object arg : args){
            System.out.print(arg+"  ");
        }
        System.out.println("");
    }

    public static void print(Map<?, ?> map){
        print("\n " + map.getClass().getSimpleName());
        for(Map.Entry<?,?> entry : map.entrySet()){
            print(entry);
        }
    }

    public static void print(){
        System.out.println("");
    }

    public static void printInLine(Object... args){
        for(Object arg : args){
            System.out.print(arg+"  ");
        }
    }
}
