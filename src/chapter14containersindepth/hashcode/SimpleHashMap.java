package chapter14containersindepth.hashcode;

import myutil.Countries;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.07.17.
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private int size = 5;
    private double loadFactor = 0.75F;
    private List<MapEntry<K, V>>[] buckets;

    // Constructor
    public SimpleHashMap(){
        buckets = new LinkedList[size];
    }

    public V put(K key, V value){
        MapEntry<K, V> newEntry = new MapEntry<>(key, value);
        V oldValue = null;
        int bucketsIndex = countBucketsIndex(key.hashCode());
        List<MapEntry<K, V>> bucket = buckets[bucketsIndex];
        if(bucket == null){
            bucket = new LinkedList<>();
            bucket.add(newEntry);
            buckets[bucketsIndex] = bucket;
        } else {
            boolean alreadyExists = false;
            Iterator<MapEntry<K, V>> it = bucket.iterator();
            while(it.hasNext() && !alreadyExists){
                MapEntry<K, V> currentEntry = it.next();
                if(currentEntry.equals(newEntry)){
                    oldValue = currentEntry.getValue();
                    currentEntry.setValue(value);
                    alreadyExists = true;
                }
            }
            if(!alreadyExists){
                bucket.add(newEntry);
            }
        }
        return value;
    }

    private int countBucketsIndex(int hashCode){
        return Math.abs(hashCode) % size;
    }

    public V get(Object key){
        int bucketsIndex = countBucketsIndex(key.hashCode());
        List<MapEntry<K, V>> bucket = buckets[bucketsIndex];
        V value = null;
        if(bucket == null)
            return null;
        Iterator<MapEntry<K, V>> it = bucket.iterator();
        boolean found = false;
        while(it.hasNext() || !found){
            MapEntry<K, V> currentEntry = it.next();
            if(currentEntry.getKey().equals(key)){
                value = currentEntry.getValue();
                found = true;
            }
        }
        return value;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for(List<MapEntry<K, V>> bucket : buckets){
            if(bucket == null)
                continue;
            for(MapEntry<K, V> entry : bucket)
                set.add(entry);
        }
        return set;
    }

    public static void main(String... args){
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        String key = "key";
        String value = "value";
        map.put(key, value);
        print(map);
        print(map.get(key));
        value = "value2";
        print(map.get(key));

        Map<Integer, Integer> map2 = new HashMap<>();
        Integer key2 = 1;
        Integer value2 = 1;
        map2.put(key2, value2);
        print(map2.get(key2));
        value2 = 2;
        print(map2.get(key2));

    }
}
