package chapter12generics.latenttyping;

import chapter12generics.Generator;

import java.util.Collection;

/**
 * Created by nayanzin on 21.07.17.
 */

interface Addable<T>{
    void add(T t);
}

// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }
    public void add(T item) { c.add(item); }
}

public class FillCollection {

    public static <T> void fillWhithToken(Addable<T> addable,
           Class<? extends T> classToken, int size){
        for(int i = 0; i< size; i++){
            try {
                addable.add(classToken.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void fillWhithGenerator(Addable<T> addable,
                                Generator<T> generator, int size) {
        for (int i = 0; i < size; i++)
            addable.add(generator.next());
    }

    // A Helper to capture the type automatically:
    public static <T> Addable<T> getCollectionAdapter(Collection<T> c) {
            return new AddableCollectionAdapter<T>(c);
    }


}
