package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 28.06.17.
 */

interface Selector{
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size){
        items = new Object[size];
    }

    public int getSize(){
        return items.length;
    }

    public void add(Object obj){
        if(next < items.length){
            items[next++] = obj;
        }
    }

    private class SequenceSelector implements Selector{
        private int currPosition = 0;
        @Override
        public boolean end(){
            return currPosition >= items.length;
        }

        @Override
        public Object current(){
            return items[currPosition];
        }

        @Override
        public void next(){
            if(currPosition < items.length)
                currPosition++;
        }

        public Sequence getSequence(){
            return Sequence.this;
        }

    }

    public Selector getSelector(){
        return new SequenceSelector();
    }

    public static void main(String... args){
        Sequence sequence = new Sequence(10);
        for(int i = 0; i < sequence.getSize(); i++){
            sequence.add(new Integer(i * i));
        }
        //Selector selector = sequence.getSelector();
        Selector selector = sequence.new SequenceSelector();
        Sequence sequence2 = ( (SequenceSelector) selector).getSequence();
        while(!selector.end()){
            print(selector.current());
            selector.next();
        }
    }
}
