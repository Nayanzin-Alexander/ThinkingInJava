package chapter14containersindepth.hashcode;

import myutil.Countries;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.07.17.
 */
public class SlowMap<K,V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    public V put(K key, V value){
        V oldValue = get(key);
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    public V get(Object key){
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> keyIt = keys.iterator();
        Iterator<V> valueIt = values.iterator();
        while(keyIt.hasNext()){
            Map.Entry<K, V> entry = new MapEntry<>(keyIt.next(), valueIt.next());
            set.add(entry);
        }
        return set;
    }

    public static void main(String... args){
        SlowMap<String,String> m= new SlowMap<String,String>();
        m.putAll(Countries.capitals(40));
        print(m);
        print(m.get("BULGARIA"));
        print(m.get("BENIN"));

        print(m.entrySet());
    }
}
