package chapter13arraysindepth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 24.07.17.
 */

class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    public String toString() { return "Sphere " + id; }
}

public class ContainerComparison {
    public static void main(String... args){
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for(int i=0; i<5; i++){
            spheres[i] = new BerylliumSphere();
        }
        print(Arrays.toString(spheres));
        print(spheres[4]);

        List<BerylliumSphere> sphereList = new ArrayList<>();
        for(int i=0; i<5; i++){
            sphereList.add(new BerylliumSphere());
        }
        print(sphereList);
        print(sphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5 };
        print(Arrays.toString(integers));
        print(integers[4]);

        List<Integer> intList = new ArrayList<>(Arrays.asList(
                0, 1, 2, 3, 4, 5
        ));
        intList.add(97);
        print(intList);
        print(intList.get(4));

        Integer[] ints = {1,2,3,4,5};
        Double[] doubles = {1d, 2d, 3d, 4d};
        new ClassParameter<Integer>().f(ints);
        // !new ClassParameter<Integer>().f(doubles);
        MethodParameter.<Double>f(doubles);
        MethodParameter.<Integer>f(ints);
        MethodParameter.f(ints);
        MethodParameter.f(doubles);
    }
}

class ClassParameter<T>{
    public T[] f(T[] args){
        return args;
    }
}

class MethodParameter{
    public static <T> T[] f(T[] args){
        return args;
    }
}
