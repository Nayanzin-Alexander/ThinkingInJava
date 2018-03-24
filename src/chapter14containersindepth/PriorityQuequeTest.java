package chapter14containersindepth;

import chapter12generics.Generator;
import myutil.RandomGenerator;

import java.util.PriorityQueue;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.07.17.
 */
public class PriorityQuequeTest extends PriorityQueue<PriorityQuequeTest.ToDoItem> {
    class ToDoItem implements Comparable<ToDoItem>{
        private Generator<Integer> intGen = new RandomGenerator.Integer(10);
        private Generator<Character> charGen = new RandomGenerator.Character();

        private char primary  = charGen.next();
        private int secondary = intGen.next();
        private String msg;


        // Constructor
        private ToDoItem(String msg){
            this.msg = msg;
        }

        @Override
        public int compareTo(ToDoItem i){
            if(primary < i.primary)
                return -1;
            else if(primary > i.primary)
                return 1;
            else if(primary == i.primary){
                if(secondary < i.secondary)
                    return -1;
                else if(secondary > i.secondary)
                    return 1;
                else
                    return 0;
            } else
                return 0;
        }

        @Override
        public String toString(){
            return "" + primary + "" + secondary + "  " + msg;
        }
    }

    public void add(String msg){
        super.add(new ToDoItem(msg));
    }

    public static void main(String... args){
        PriorityQuequeTest test = new PriorityQuequeTest();
        test.add("Feed the dog");
        test.add("Remove the trash");
        test.add("Wash the car");
        test.add("Study");
        test.add("Work");
        while(!test.isEmpty())
            print(test.remove());

    }
}
