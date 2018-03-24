package myutil;

/**
 * Created by nayanzin on 01.08.17.
 */

import chapter14containersindepth.perfomancetestframework.LambdaTester;
import chapter14containersindepth.perfomancetestframework.TestParam;
import chapter14containersindepth.perfomancetestframework.Testable;

import java.util.*;


/**
 * Created by nayanzin on 31.07.17.
 */
public class MapPerfomance {
    private static Map<String, Testable<Map<Integer, Integer>>> tests = new LinkedHashMap<>();
    private static List<TestParam> params = new ArrayList<>();

    class MapTester extends LambdaTester<Map<Integer ,Integer>> {

        public MapTester(Map<Integer ,Integer> container, Map<String, Testable<Map<Integer ,Integer>>> tests) {
            super(container, tests);
        }

        @Override
        protected  Map<Integer ,Integer> initialize(int size) {
            container.clear();
            Random rand = new Random(47);
            for(int i=0; i < size; i++)
                container.put(rand.nextInt(), rand.nextInt());
            return container;
        }
    }
    static {
        tests.put("put", (Map<Integer ,Integer> map, TestParam tp) -> {
            int loops = tp.loops;
            int size = tp.size;
            for(int i = 0; i < loops; i++) {
                map.clear();
                for(int j = 0; j < size; j++)
                    map.put(j, j);
            }
            return loops * size;
        });
        tests.put("get", (Map<Integer ,Integer> map, TestParam tp) -> {
            int loops = tp.loops;
            int size = tp.size;
            for(int i = 0; i < loops; i++) {
                for(int j = 0; j < size; j++)
                    map.get(j);
            }
            return loops * size;
        });
        tests.put("iterate", (Map<Integer ,Integer> map, TestParam tp) -> {
            int loops = tp.loops;
            int size = tp.size;
            for(int i = 0; i < loops; i++) {
                for(Map.Entry<Integer, Integer> entry : map.entrySet())
                    ;
            }
            return loops * size;
        });

    }

    public static void main(String... args){
        MapTester.run(new TreeMap<>(), tests);
        MapTester.run(new HashMap<>(), tests);
        MapTester.run(new LinkedHashMap<>(), tests);
        MapTester.run(new IdentityHashMap<>(), tests);
        MapTester.run(new WeakHashMap<>(), tests);
        MapTester.run(new Hashtable<>(), tests);
    }
}

