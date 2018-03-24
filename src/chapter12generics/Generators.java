package chapter12generics;

import java.util.Collection;

/**
 * Created by nayanzin on 13.07.17.
 */
public class Generators {
    public static <T> Collection<T>
    fill(Collection<T> coll, Generator<T> gen, int n) {
        for(int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }
}