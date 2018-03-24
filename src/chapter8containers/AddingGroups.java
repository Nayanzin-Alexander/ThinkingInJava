package chapter8containers;

import static myutil.Printer.*;

import java.util.*;

/**
 * Created by nayanzin on 03.07.17.
 */
public class AddingGroups{

    public static Collection fill(Collection<String> collection){
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    public static Map<String, String> fill(Map<String, String> map){
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String... args){
        print(fill(new ArrayList<String>()));
        print(fill(new LinkedList<String>()));
        print(fill(new HashSet<String>()));
        print(fill(new TreeSet<String>()));
        print(fill(new LinkedHashSet<String>()));

        print(fill(new HashMap()));
        print(fill(new TreeMap()));
        print(fill(new LinkedHashMap()));


    }

}
