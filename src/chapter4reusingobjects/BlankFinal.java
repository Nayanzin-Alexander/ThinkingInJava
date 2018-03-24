package chapter4reusingobjects;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 26.06.17.
 */
class InnerClass{
    InnerClass(){
        print("Inner class constructor");
    }
}
public class BlankFinal {
    final InnerClass innerClass;

    public BlankFinal() {
        innerClass = null;
    }

    public static void main(String... args){
        BlankFinal bf = new BlankFinal();
        //bf.innerClass = new InnerClass();
    }
}
