package chapter14containersindepth;

import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 27.07.17.
 */
public class Unsuported {
    static void test(String msg, List<String> list){
        print(msg);
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);

        //Copy of subList
        Collection<String> c2 = new ArrayList<>(subList);

        try{
            c.retainAll(c2);
        } catch(Exception e){
            print("retainAll caused exception :" + e.getMessage());
        }

        try {
            c.removeAll(c2);
        } catch(Exception e) {
            print("removeAll caused exception :" + e.getMessage());
        }

        try {
            c.clear();
        } catch(Exception e) {
            print("clear caused exception :" + e.getMessage());
        }

        try {
            c.add("X");
        } catch(Exception e) {
            print("add(\"X\") caused exception :" + e.getMessage());
        }

        try {
            c.addAll(c2);
        } catch(Exception e) {
            print("addAll caused exception :" + e.getMessage());
        }
        try {
            c.remove("C");
        } catch(Exception e) {
            print("remove(\"C\" caused exception :" + e.getMessage());
        }

        try {
            list.set(0, "X");
        } catch(Exception e) {
            print("set caused exception :" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()",
                Collections.unmodifiableList(
                        new ArrayList<String>(list)));
    }
}
