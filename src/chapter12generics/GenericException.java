package chapter12generics;

import java.util.ArrayList;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 20.07.17.
 */

interface Processor<T, E extends Exception>{
    void process(List<T> resultCollector) throws E;
}

class ProcessRunner<T, E extends Exception>
        extends ArrayList<Processor<T, E>>{
    List<T> processAll() throws E{
        List<T> resultCollector = new ArrayList<>();
        for(Processor<T, E> processor : this){
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception{}

class Processor1 implements Processor<String, Failure1>{
    static int count = 3;
    public void process(List<String> resultCollector)
        throws Failure1{
        if(count-- >1){
            resultCollector.add("Help!");
        } else {
            resultCollector.add("Ho!");
        }
        if(count < 0){
            throw new Failure1();
        }
    }
}

class Failure2 extends Exception{}

class Processor2 implements Processor<Integer, Failure2>{
    static int count = 2;
    @Override
    public void process(List<Integer> resultCollector) throws Failure2 {
        if(count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }
        if(count < 0){
            throw new Failure2();
        }
    }
}

public class GenericException<K, E extends Exception>{
    public static void main(String... args){
        ProcessRunner<String, Failure1> runner = new ProcessRunner<>();
        runner.add(new Processor1());
        runner.add(new Processor1());
        runner.add(new Processor1());
        try{
            print(runner.processAll());
        } catch(Failure1 f){
            print(f);
        }

        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
        runner2.add(new Processor2());
        runner2.add(new Processor2());
        runner2.add(new Processor2());
        try{
            print(runner2.processAll());
        } catch(Failure2 f){
            print(f);
        }


    }
}
