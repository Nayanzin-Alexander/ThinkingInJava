package myutil;

import chapter14containersindepth.CountingIntegerList;
import chapter14containersindepth.perfomancetestframework.LambdaTester;
import chapter14containersindepth.perfomancetestframework.TestParam;
import chapter14containersindepth.perfomancetestframework.Testable;

import java.util.*;

/**
 * Created by nayanzin on 31.07.17.
 */
public class SetPerfomance {
    private static Map<String, Testable<Set<Integer>>> tests = new LinkedHashMap<>();
    private static List<TestParam> params = new ArrayList<>();

    class SetTester extends LambdaTester<Set<Integer>>{

        public SetTester(Set<Integer> container, Map<String, Testable<Set<Integer>>> tests) {
            super(container, tests);
        }

        @Override
        protected  Set<Integer> initialize(int size) {
            container.clear();
            Random rand = new Random(47);
            for(int i=0; i < size; i++)
                container.add(rand.nextInt());
            return container;
        }
    }
    static {
        tests.put("add", (Set<Integer> set, TestParam tp) -> {
            int loops = tp.loops;
            int size = tp.size;
            for(int i = 0; i < loops; i++) {
                set.clear();
                for(int j = 0; j < size; j++)
                    set.add(j);
            }
            return loops * size;
        });
        tests.put("contains", (Set<Integer> set, TestParam tp) -> {
            for(int i=0; i<tp.loops * tp.size; i++)
                set.contains(i);
            return tp.loops * tp.size;
        });
        tests.put("iterate", (Set<Integer> set, TestParam tp) -> {
            int loops = tp.loops;
            for(int i=0; i < loops; i++){
                Iterator<Integer> it = set.iterator();
                while(it.hasNext())
                    it.next();
            }
            return loops * set.size();
        });
    }

    public static void main(String... args){
        SetTester.run(new TreeSet<Integer>(), tests);
        SetTester.run(new HashSet<Integer>(), tests);
        SetTester.run(new LinkedHashSet<Integer>(), tests);
    }
}
