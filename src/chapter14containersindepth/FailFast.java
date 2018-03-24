package chapter14containersindepth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by nayanzin on 01.08.17.
 */
    public class FailFast {
        public static void main(String[] args) {
            Collection<String> c = new ArrayList<String>();
            Iterator<String> it = c.iterator();
            c.add("An object");
            try {
                String s = it.next();
            } catch(ConcurrentModificationException e) {
                System.out.println(e);
            }
        }
    }
