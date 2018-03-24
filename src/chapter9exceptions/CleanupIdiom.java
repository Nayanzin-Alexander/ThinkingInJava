package chapter9exceptions;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 05.07.17.
 */

class NeedsCleanup{
    private static long counter = 1;
    private final long ID = counter++;
    public void dispose(){
        print("Disposed " + ID);
    }
}

class ConstructionException extends Exception{}

class NeedsCleanup2 extends NeedsCleanup{
    //Constructor can fail:
    NeedsCleanup2() throws ConstructionException{}
}

public class CleanupIdiom {
    public static void main(String...args) {
        //section 1:
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            //....
        } finally {
            nc1.dispose();
        }

        //section 2:
        // If construction cannot fail you can group objects:
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            //....
        } finally {
            nc3.dispose(); // reverse order of construction
            nc2.dispose();
        }

        // Section 3:
        // If construction can fail you must guard each one:
        try{
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try{
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try{
                    //....some work with nc5
                }finally{
                    nc5.dispose();
                }
            } catch (ConstructionException e){
                print(e);
            }
            try{
                //...some work with nc4
            }finally{
                nc4.dispose();
            }
        } catch (ConstructionException e){
            print(e);
        }
    }

}
// Very beautiful example... so sad...
// Looks like I'm finally catched trying
