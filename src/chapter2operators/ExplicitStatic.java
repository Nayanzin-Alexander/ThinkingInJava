package chapter2operators;

/**
 * Created by nayanzin on 23.06.17.
 */

class Cup{
    static int commonInt;
    Cup(int marker){
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups{
    static Cup cup1;
    static Cup cup2;
    static{
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    String name;
    {
        name = "My cups";
    }
    Cups(){
        System.out.println("Cups");
    }
}

public class ExplicitStatic {
    public static void main(String[] args){
        System.out.println("Inside main");
        Cups.cup1.f(1);
        Cups.cup1.commonInt = 10;
        System.out.println(Cups.cup2.commonInt);
        Cups cups = new Cups();
        System.out.println(cups.name);
    }
}
