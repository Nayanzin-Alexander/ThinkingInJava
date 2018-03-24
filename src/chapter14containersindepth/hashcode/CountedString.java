package chapter14containersindepth.hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 30.07.17.
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;

    public CountedString(String str) {
        s =str;
        created.add(s);
        // id is the total number of instances
        // of this string use my CountedString:
        for(String s2 : created)
            if(s2.equals(s))
                id++;
    }

    @Override
    public String toString() {
        return String.format("%s id:%d hashCode:%d", s, id, hashCode());
    }

    @Override
    public int hashCode() {
        // The very simple approach
        // Return s.hashCode() * id;
        // Using Joshua Bloch's recipe:
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof CountedString) &&
                (s.equals( ((CountedString) o).s)) &&
                (id == ((CountedString) o).id);
    }

    public static void main(String... args){
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for(int i=0; i<cs.length; i++){
            cs[i] = new CountedString("hi");
            map.put(cs[i], i); // Autobox int -> Integer
        }
        print(map);
        for(CountedString csStr : cs){
            print(String.format("Looking up %s", csStr));
            print(String.format("Found %s", map.get(csStr)));
        }
    }
}
