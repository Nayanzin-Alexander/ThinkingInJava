package chapter14containersindepth;


import chapter12generics.Generator;

import java.util.LinkedHashMap;

/**
 * Created by nayanzin on 26.07.17.
 */

public class MapData<K, V> extends LinkedHashMap<K, V>{

    // A single pair generator
    public MapData(Generator<Pair<K, V>> gen, int quantity){
        for(int i=0; i<quantity; i++){
            Pair<K, V> pair = gen.next();
            put(pair.key, pair.value);
        }
    }

    // Two separate Generators
    public MapData(Generator<K> keyGen, Generator<V> valueGen, int quantity){
        for(int i=0; i<quantity; i++){
            put(keyGen.next(), valueGen.next());
        }
    }

    // A key generator and a single value
    public MapData(Generator<K> keyGen, V value, int quantity){
        for(int i=0; i<quantity; i++){
            put(keyGen.next(), value);
        }
    }

    // An Iterable and a value Generator:
    public MapData(Iterable<K> iterableKey, Generator<V> valueGen){
        for(K key : iterableKey){
            this.put(key, valueGen.next());
        }
    }

    // An Iterable and a single value:
    public MapData(Iterable<K> iterableKey, V value){
        for(K key : iterableKey){
            this.put(key, value);
        }
    }


    // Generic convenience methods:
    public static <K, V> MapData<K, V> map(Generator<Pair<K,V>> gen, int quantity){
        return new MapData<K, V>(gen, quantity);
    }

    public static <K, V> MapData<K, V> map(
            Generator<K> keyGen, Generator<V> valueGen, int quantity){
        return new MapData<K, V>(keyGen, valueGen, quantity);
    }

    public static <K, V> MapData<K, V> map(
            Generator<K> keyGen, V value, int quantity){
        return new MapData<K, V>(keyGen, value, quantity);
    }

    public static <K, V> MapData<K, V> map(
            Iterable<K> iterableKey, Generator<V> valueGen){
        return new MapData<K, V>(iterableKey, valueGen);
    }

    public static <K, V> MapData<K, V> map(
            Iterable<K> iterableKey, V value){
        return new MapData<K, V>(iterableKey, value);
    }
}
