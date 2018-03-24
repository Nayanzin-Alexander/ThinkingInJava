package chapter14containersindepth;

import java.util.Iterator;

/**
 * Created by nayanzin on 27.07.17.
 * Exercise 8: (7) Create a generic, singly linked list class called SList, which, to keep
 * things simple, does not implement the List interface. Each Link object in the list should
 * contain a reference to the next element in the list, but not the previous one (LinkedList, in
 * contrast, is a doubly linked list, which means it maintains links in both directions).
 * Create your own SListIterator which, again for simplicity, does not implement ListIterator. The
 * only method in SList other than toString( ) should be iterator( ), which produces an
 * SListIterator. The only way to insert and remove elements from an SList is through
 * SListIterator. Write code to demonstrate SList.
 */
public class Exersice8<T> {
    private int size = 0;
    private Node<T> root = null;
    private Node<T> tail = null;
    private class Node<T>{
        private Node<T> next;
        private T value;

        //constructor
        public Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }

        public Node<T> deleteNode(){
            value = null;
            return next;
        }

        public Node<T> getNext(){
            return next;
        }

        public void setNext(Node<T> node){
            next = node;
        }

        public T getValue(){
            return value;
        }

        public void setValue(T value){
            this.value = value;
        }
    }

    public Iterator<T> iterator(){
        return new SListIterator();
    }

    private class SListIterator implements Iterator<T>{
        Node<T> current = root;

        @Override
        public boolean hasNext() {
            if(current == null || current.getNext() == null)
                return false;
            return true;
        }

        @Override
        public T next() {
            T value = current.getValue();
            current = current.getNext();
            return value;
        }

        @Override
        public void remove(){

        }
    }

}
