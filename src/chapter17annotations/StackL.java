package chapter17annotations;

import java.util.LinkedList;

/**
 * Created by nayanzin on 24.08.17.
 */
public class StackL <T> {
    private LinkedList<T> list = new LinkedList<>();
    public void push(T v) { list.addFirst(v); }
    public T top() { return list.getFirst(); }
    public T pop() { return list.removeFirst(); }
}
