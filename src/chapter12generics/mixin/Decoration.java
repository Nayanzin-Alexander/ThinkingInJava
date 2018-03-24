package chapter12generics.mixin;

import java.util.Date;

/**
 * Created by nayanzin on 20.07.17.
 */

class Basic1{
    private String value;
    public void set(String value){
        this.value = value;
    }
    public String get(){
        return value;
    }
}

class Decorator extends Basic1{
    protected Basic1 basic;
    public Decorator(Basic1 basic){
        this.basic = basic;
    }
    public void set(String val){
        basic.set(val);
    }
    public String get(){
        return basic.get();
    }
}

class TimeStamped1 extends Decorator{
    private final long timeStamp;
    public TimeStamped1(Basic1 basic){
        super(basic);
        timeStamp = new Date().getTime();
    }
    public long getStamp(){
        return timeStamp;
    }
}

class SerialNumbered1 extends Decorator{
    private static long counter = 1;
    private final long SERIAL_NUMBER = counter++;
    public SerialNumbered1(Basic1 basic){
        super(basic);
    }
    public long getID(){
        return SERIAL_NUMBER;
    }
}

public class Decoration {
    public static void main(String... args){
        TimeStamped1 t1 = new TimeStamped1(new Basic1());
        TimeStamped1 t2 = new TimeStamped1(new SerialNumbered1(new Basic1()));

        t1.getStamp();
        t2.getStamp();

        SerialNumbered1 s1 = new SerialNumbered1(new Basic1());
        SerialNumbered1 s2 = new SerialNumbered1(new TimeStamped1(new Basic1()));

        s1.getID();
        s2.getID();


    }
}
