package chapter8containers;

import java.util.LinkedList;

/**
 * Created by nayanzin on 03.07.17.
 */
public class Stack<T> {
    private LinkedList<T> stack = new LinkedList<>();
    public void push(T element){
        stack.addFirst(element);
    }
    public T peak(){
        return stack.getFirst();
    }
    public T pop(){
        return stack.removeFirst();
    }
    public boolean empty(){
        return stack.isEmpty();
    }
    public String toString(){
        return stack.toString();
    }

}
