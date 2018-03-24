package chapter7innerclasses;

/**
 * Created by nayanzin on 29.06.17.
 */

class Wrapping{
    private int i;
    Wrapping(int i){
        this.i = i;
    }
    int getValue(){
        return i;
    }
}

public class Parcel8 {
    public Wrapping getWrapping(int j){
        return new Wrapping(j){
            @Override
            int getValue(){
                return super.getValue() * j;
            }
        };
    }

    public static void main(String... args){
        Parcel8 p8 = new Parcel8();
        p8.getWrapping(10).getValue();
    }
}
