package chapter11typeinformation;

import java.util.ArrayList;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 10.07.17.
 */

class CountedInteger{
    private static long counter;
    private final long ID = counter++;
    public String toString(){
        return "ID = " + ID;
    }
}

public class FilledList<T> {
    private Class<T> type;

    public FilledList(Class<T> type){
        this.type = type;
    }

    public List<T> create(int nElements){
        List<T> result = new ArrayList<>();
        try{
            for(int i=0; i < nElements; i++){
                result.add(type.newInstance());
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String... args){
        FilledList<CountedInteger> filledList = new FilledList<>(CountedInteger.class);
        print(filledList.create(10));
    }
}
