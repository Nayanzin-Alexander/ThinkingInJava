package chapter12generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nayanzin on 19.07.17.
 */
public class ByteSet {
    Byte[] possibles = {1,2,3,4,5,6,7,8,9};
    Set<Byte> mySet =
            new HashSet<Byte>(Arrays.asList(possibles));

    Set<Byte> mySet2 =
            new HashSet<Byte>(Arrays.<Byte>asList(possibles));
}
