package chapter14containersindepth;

import java.util.AbstractList;

/**
 * Created by nayanzin on 27.07.17.
 */
public class CountingIntegerList extends AbstractList<Integer> {

    private int size;

    //Constructor
    public CountingIntegerList(int size){
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
    }
}
