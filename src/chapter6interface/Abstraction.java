package chapter6interface;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 28.06.17.
 */
public abstract class Abstraction {
    public int i;
    public int j;
    public abstract void abstractMethod();
    public void simpleMethod(){
        print("inside simpleMethod");
    }
}

class Descendant extends Abstraction{

    @Override
    public void abstractMethod() {

    }
}
