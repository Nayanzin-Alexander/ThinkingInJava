package chapter13arraysindepth;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nayanzin on 25.07.17.
 */
public class ArrayOfGenerics {

    public static void main(String... args){
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la; // "Unchecked" warning
        ls[0] = new ArrayList<String>();

        // Compile-time checking produces an error:
        //! ls[1] = new ArrayList<Integer>();

        // The problem: List<String> is a subtype of Object
        Object[] objects = ls; // So assignment is OK
        // Compiles and runs without complaint:
        objects[1] = new ArrayList<Integer>();




    }
}
