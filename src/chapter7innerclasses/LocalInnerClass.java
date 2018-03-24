package chapter7innerclasses;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 02.07.17.
 */

interface Counter{
    int next();
}

public class LocalInnerClass {
    private int count = 0;
    int getCount(){
        return count;
    }
    Counter getLocalCounter(final String name){
        class LocalCounter implements Counter{
            LocalCounter(){
                print("LocalCounter constructor");
            }
            @Override
            public int next(){
                print(name);
                return count++;
            }
        }

        return new LocalCounter();
    }
    Counter getAnonymousCounter(final String name){
        return new Counter(){
            {
                print("Pseudo anonyous constructor");
            }
            @Override
            public int next(){
                print(name);
                return count++;
            }
        };
    }

    public static void main(String... args){
        LocalInnerClass localInnerClass = new LocalInnerClass();
        Counter localCounter = localInnerClass.getLocalCounter("Local");
        Counter anonymousCounter = localInnerClass.getAnonymousCounter("Anonymous");

        localCounter.next();
        localCounter.next();
        anonymousCounter.next();
        anonymousCounter.next();
        print(localInnerClass.getCount());
    }
}
