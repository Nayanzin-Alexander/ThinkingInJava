package chapter14containersindepth;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.07.17.
 */
public class Maps {

    public static <K, V> void printKeys(Map<K, V> map){
        print(map.keySet());
    }

    public static void test(Map<Integer, String> map){
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Map has ‘Set’ behavior for keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);

        // Producing a Collection of the values:
        print("Values: ");
        print(map.values());
        print(map);
        print("map.containsKey(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): "
                + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));

        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());

    }

    public static void main(String... args){
        test(new HashMap<>());
        test(new TreeMap<>());
    }
}
