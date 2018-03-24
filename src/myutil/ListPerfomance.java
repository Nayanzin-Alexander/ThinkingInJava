package myutil;

import chapter14containersindepth.CountingIntegerList;
import chapter14containersindepth.PriorityQuequeTest;
import chapter14containersindepth.perfomancetestframework.*;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by nayanzin on 31.07.17.
 */
public class ListPerfomance {
    static Random rand = new Random();
    static int reps = 1000;
    static Map<String, Testable<LinkedList<Integer>>> qTests = new HashMap<>();
    static Map<String, Testable<List<Integer>>> lambdaTests = new HashMap<>();

    static {
        // Tests for List behavior

        // TestJunit1 lambdas for List
        lambdaTests.put("add", (List<Integer> list, TestParam tp) -> {
            int loops = tp.loops;
            int listSize = tp.size;
            for (int i = 0; i < loops; i++) {
                list.clear();
                for (int j = 0; j < listSize; j++)
                    list.add(j);
            }
            return loops;
        });
        lambdaTests.put("get", (List<Integer> list, TestParam tp) -> {
            int loops = tp.loops * tp.size;
            for (int i = 0; i < loops; i++) {
                list.get(rand.nextInt(tp.size));
            }
            return loops;
        });
        lambdaTests.put("set", (List<Integer> list, TestParam tp) -> {
            int loops = tp.loops * tp.size;
            for (int i = 0; i < loops; i++) {
                list.set(rand.nextInt(tp.size), 47);
            }
            return loops;
        });
        lambdaTests.put("iteradd", (List<Integer> list, TestParam tp) -> {
            int loops = tp.loops * tp.size;
            int middle = tp.size / 2;
            ListIterator<Integer> it =list.listIterator(middle);
            for(int i=0; i< loops; i++)
                it.add(47);
            return loops;
        });
        lambdaTests.put("insert", (List<Integer> list, TestParam tp) -> {
            int loops = tp.loops;
            for(int i=0; i< loops; i++) {
                list.add(rand.nextInt(tp.size), 47);
            }
            return loops;
        });

        // Tests for queue behavior
        qTests.put("addFirst", (LinkedList<Integer> list, TestParam tp) ->{
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst(47);
                }
                return loops * size;
            });
        qTests.put("addLast", (LinkedList<Integer> list, TestParam tp) ->{
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast(47);
                }
                return loops * size;
        });
        qTests.put("rmFirst", (LinkedList<Integer> list, TestParam tp) ->{
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 0)
                        list.removeFirst();
                }
                return loops * size;
        });
        qTests.put("rmLast", (LinkedList<Integer> list, TestParam tp) ->{
                int loops = tp.loops;
                int size = tp.size;
                for(int i=0; i<loops; i++){
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size() > 0)
                        list.removeLast();
                }
                return loops;
        });
    }

    static class ListLambdaTester extends LambdaTester<List<Integer>> {
        public ListLambdaTester(List<Integer> container, Map<String, Testable<List<Integer>>> tests){
            super(container, tests);
        }
        // Fill to the appropriate size before each test:
        @Override
        protected List<Integer> initialize(int size){
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }
    }

    public static void main(String[] args) {
        ListLambdaTester.run(new ArrayList<Integer>(), lambdaTests);
        ListLambdaTester.run(new LinkedList<Integer>(), lambdaTests);
        ListLambdaTester.run(new Vector<Integer>(), lambdaTests);

        ListLambdaTester.run(new LinkedList<Integer>(), qTests);

  }
}
