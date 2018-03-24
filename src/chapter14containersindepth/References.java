package chapter14containersindepth;

import java.lang.ref.*;
import java.util.LinkedList;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 02.08.17.
 */

class VeryBig {
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id){
        ident = id;
    }
    public String toString(){
        return ident;
    }
    protected void finalize() {
        print("Finalazing " + ident);
    }

}

public class References {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();

    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if(inq != null)
            print("In queue: " + inq.get());
    }
    public static void main(String... args) {
        int size = 10;

        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        for(int i =0; i<size; i++){
            sa.add(new SoftReference<VeryBig>( new VeryBig("Soft " + i), rq));
        }
        print("Just created: " + sa.getLast());
        checkQueue();

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
        for(int i =0; i<size; i++){
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i), rq));
        }
        print("Just created: " + wa.getLast());
        checkQueue();

        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));

        System.gc();

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for(int i =0; i<size; i++){
            pa.add(new PhantomReference<VeryBig>(new VeryBig("PhantomReference " + i), rq));
        }
        print("Just created: " + pa.getLast());
        checkQueue();



    }
}
