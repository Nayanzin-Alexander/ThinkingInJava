package myutil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nayanzin on 11.07.17.
 */
public class MapData<K,V> {
    public static Map map(Iterable it, int def){
        Map result = new HashMap();
        for(Object element : it){
            result.put(element, def);
        }
        return result;
    }
}
