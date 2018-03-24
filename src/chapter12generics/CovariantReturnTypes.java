package chapter12generics;

/**
 * Created by nayanzin on 19.07.17.
 */

interface GenericGetter <T extends GenericGetter>{
    T get();
}

interface Getter extends GenericGetter<Getter>{
}

public class CovariantReturnTypes {
    void test(Getter g){
        Getter result = g.get();
        GenericGetter gg = g.get();
    }

}
