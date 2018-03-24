package chapter2operators;

/**
 * Created by nayanzin on 21.06.17.
 */

class SomeClass{
    int someIntValue;
}
public class PassingObjectToMethod {
    public static void change(SomeClass someClass){
        someClass.someIntValue = 55;
    }

    public static void main(String[] args){
        SomeClass someClass = new SomeClass();
        someClass.someIntValue = 10;
        System.out.println("someIntValue is "+someClass.someIntValue);
        System.out.println("Calling method change");
        change(someClass);
        System.out.println("Now someIntValue is "+someClass.someIntValue);

    }
}
