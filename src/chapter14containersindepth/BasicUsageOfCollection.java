package chapter14containersindepth;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 01.08.17.
 */

public class BasicUsageOfCollection {
    static List<String> list = Arrays.asList(
            "one Two three Four five six one".split(" "));
    public static void main(String... args){
        print(list);

        print("List disjoint (Four) " +
                Collections.disjoint(list, Collections.singletonList("Four")));
        print("max: " + Collections.max(list));
        print("min: " + Collections.min(list));
        print("max with comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        print("min with comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));

        List<String> sublist = Arrays.asList("Four five six".split(" "));
        print("indexOfSublist: " + Collections.indexOfSubList(list, sublist));
        print("lastIndexOfSublist: " + Collections.lastIndexOfSubList(list, sublist));

        Collections.replaceAll(list, "one", "Yo");
        print("replaceAll: " + list);

        Collections.reverse(list);
        print("reverse: " + list);

        Collections.rotate(list, 3);
        print("rotate(3): " + list);

        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        print("copy: " + list);

        Collections.swap(list, 0, list.size() - 1);
        print("swap: " + list);

        Collections.shuffle(list, new Random(47));
        print("shuffled: " + list);

        Collections.fill(list, "pop");
        print("fill(pop): " + list);

        print("frequency pop: " + Collections.frequency(list, "pop"));
        List<String> dups = Collections.nCopies(3, "snap");
        print("dups: " + dups);
        print("list disjoint dups: " + Collections.disjoint(list, dups));

        // Getting an old-style Enumeration:
        Enumeration<String> e = Collections.enumeration(dups);
        Vector<String> v = new Vector<>();
        while(e.hasMoreElements())
            v.addElement(e.nextElement());

        // Converting an old-style Vector to a List
        ArrayList<String> arrayList = Collections.list(v.elements());
        print("arrayList: " + arrayList);
    }

}
