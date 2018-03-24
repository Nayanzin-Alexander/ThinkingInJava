package chapter14containersindepth;

import java.util.LinkedHashMap;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.07.17.
 */
public class LinkedHashMapDemo {
    public static void main(String... args){
        LinkedHashMap<Integer, String> linkedMap =
                new LinkedHashMap<>(new CountingMapData(10));
        print(linkedMap);

        // Leats-Recently-Order
        linkedMap = new LinkedHashMap<Integer,String>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(10));
        print(linkedMap);

        for(int i=0; i< 6; i++){
            linkedMap.get(i);
        }

        print(linkedMap);
        linkedMap.get(0);
        print(linkedMap);
    }
}
