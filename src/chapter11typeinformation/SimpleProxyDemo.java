package chapter11typeinformation;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.07.17.
 */

interface Interface{
    void doSomething();
    void doSomethingElse(String arg);
}

class RealObject implements Interface{

    @Override
    public void doSomething() {
        print("RealObject.doSomething()");
    }

    @Override
    public void doSomethingElse(String arg) {
        print("RealObject.doSomethingElse(" + arg + ")");
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;

    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }

    public void doSomething(){
        print("SimpleProxy.doSomething()");
        proxied.doSomething();
    }

    public void doSomethingElse(String arg){
        print("SimpleProxy.doSomethingElse(" + arg + ")");
        proxied.doSomethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String... args){
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
