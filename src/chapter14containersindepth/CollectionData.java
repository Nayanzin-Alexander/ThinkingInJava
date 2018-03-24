package chapter14containersindepth;

import chapter12generics.Generator;

import java.util.ArrayList;

/**
 * Created by nayanzin on 26.07.17.
 */
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int size){
        for(int i=0; i<size; i++){
            this.add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int size){
        return new CollectionData<T>(gen, size);
    }
}
