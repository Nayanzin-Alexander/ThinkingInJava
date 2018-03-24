package chapter11typeinformation;

import chapter8containers.Stack;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.07.17.
 */

interface Iface{
    void doSomething();
}

class RealObj implements Iface{
    public void doSomething(){
        print("RealObject.doSomething");
    }
}

class MyHandler implements InvocationHandler {
    Object proxied;
    public MyHandler(Object proxied){
        this.proxied = proxied;
    }

    private void beforeInvoke(){
        print("Before invoke");
    }

    private void afterInvoke(){
        print("After invoke");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        print("Invoking");
        try{
            return method.invoke(proxied, args);
        }finally{
            afterInvoke();
        }
    }
}

public class TestDynamicProxy {

    private static void consumer(Iface iface){
        iface.doSomething();
    }

    public static void main(String... args){
        Iface iface = new RealObj();
       // consumer(iface);

        // now use dynamic proxy
        MyHandler myHandler = new MyHandler(iface);
        Iface proxyStack = (Iface) (
                Proxy.newProxyInstance(Stack.class.getClassLoader(),
                        iface.getClass().getInterfaces(),
                        myHandler));
        consumer(proxyStack);
    }
}
