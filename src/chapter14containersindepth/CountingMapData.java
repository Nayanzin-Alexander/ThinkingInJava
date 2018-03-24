package chapter14containersindepth;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 27.07.17.
 */
public class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static String[] chars =
            "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size){
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        // LinkedHashSet retains initialization order:
        Set<Map.Entry<Integer,String>> entries =
                new LinkedHashSet<Map.Entry<Integer,String>>();
        for(int i = 0; i < size; i++)
            entries.add(new Entry(i));
        return entries;
    }

    class Entry implements Map.Entry<Integer, String>{
        int index;

        //Constructor
        Entry(int index) {
            this.index = index;
        }

        @Override
        public Integer getKey() {
            return Integer.valueOf(index);
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
