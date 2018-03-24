package chapter4reusingobjects;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 17.07.17.
 */

class Base{
    private int someImportandField;
    public Base(){
        someImportandField = 47;
        print("Base constructor");
    }
    public int getSomeImportandField(){
        return someImportandField;
    }
}

class Derived extends Base{
    public Derived(){
        //Looks like we don't need to use Base constructor.
        //It call's automaticaly
        //super();
        print("Derived constructor");
        print(getSomeImportandField());
    }
}

public class InitOrder2 {
    public static void main(String... args){
        Derived derived = new Derived();
    }
}
