package chapter2operators;

/**
 * Created by nayanzin on 23.06.17.
 */
public class VarArgsTest {

    private static void myMethod(Object... args){
        for(Object obj:args){
            System.out.print(obj + " ");
        }
        System.out.println("");
    }

    //Overloading Varargs
    static void f(char...args){
        System.out.print(args.getClass());
        for(char obj:args){
            System.out.print(obj + " ");
        }
        System.out.println("");
    }

    static void f(int...args){
        System.out.print(args.getClass());
        for(int obj:args){
            System.out.print(obj + " ");
        }
        System.out.println("");
    }

    static void f(float...args){
        System.out.print(args.getClass());
        for(float obj:args){
            System.out.print(obj + " ");
        }
        System.out.println("");
    }

    public static void main(String...args){
        myMethod(new Object[]{new Integer(10), "55,", 'a',
                              55d, 44f, 0xfff, 044,
                              new Integer[]{0,1,2,3,4,2}});

        f('a', 'b', 'c', 55);
        f(4, 2, 3, 55);
        f(4, 0.2f, 3, 55);

    }
}
