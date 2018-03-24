package chapter2operators;

import myutil.Printer;
/**
 * Created by nayanzin on 23.06.17.
 */
enum MyEnum{
    NOT, MILD, MEDIUM, HOT, FLAMING
}


public class EnumTest {
    public static void main(String... args){
        MyEnum myEnum;
        for(MyEnum en : MyEnum.values()){
            Printer.print(en +" ordinal "+en.ordinal());
        }
        Burrito burrito1 = new Burrito(MyEnum.FLAMING);
        Burrito burrito2 = new Burrito(MyEnum.MILD);
        Burrito burrito3 = new Burrito(MyEnum.NOT);
        burrito1.describe();
        burrito2.describe();
        burrito3.describe();
    }
}

class Burrito{
    MyEnum spiciness;

    Burrito(MyEnum spiciness){
        this.spiciness = spiciness;
    }

    void describe(){
        switch(spiciness){
            case NOT:
                System.out.println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM: System.out.println("a little hot.");
                break;
            case HOT:
            case FLAMING:
            default:
                System.out.println("maybe too hot.");
        }
    }
}
