package chapter4reusingobjects;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 27.06.17.
 */
public class SomeDescendantClass extends SomeAnchestorClass{

    @Override
    protected int provideArgument(){
        print("inside SomeDescendantClass.provideArgument()");
        return 0;
    }

    public void f(){
        print("public f()");
    }

    public static void main(String... args){
        SomeDescendantClass myClass = new SomeDescendantClass();
        print(myClass.provideCalculation(2));
        myClass.f();
    }
}/* Output:
inside SomeDescendantClass.provideArgument()
2
So, method provideArgument() was overriden
*/
