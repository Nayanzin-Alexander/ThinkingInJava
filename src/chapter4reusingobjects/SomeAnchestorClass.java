package chapter4reusingobjects;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 27.06.17.
 */
public class SomeAnchestorClass {
    public int provideCalculation(int arg1){
        return arg1 + provideArgument();
    }

    protected int provideArgument(){
        print("inside SomeAnchestorClass.provideArgument()");
        return 2;
    }

    private void f(){
        print("private f()");
    }
}
