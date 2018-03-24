package chapter12generics;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleProxies;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.security.Policy;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 16.07.17.
 */

interface SomethingDoable{
    <T> void f1(T t1);
    <T> void f2(T t1, T t2);
    <K, V> void f3(K k, V v1, V v2);
}

class RealClass implements SomethingDoable{

    public RealClass(){
        print("RealClass constructor");
    }

    @Override
    public <T> void f1(T t1) {
        print(" f1(" + t1 + ");");
    }

    @Override
    public <T> void f2(T t1, T t2) {
        print(" f2(" + t1 + ", " + t2 + ");");
    }

    @Override
    public <K, V> void f3(K k, V v1, V v2) {
        print(" f3(" + k + ", " + v1 + ", " + v2 + ");");
    }
}

class SubRealClass extends RealClass{
    public SubRealClass(){
        print("SubRealClass constructor");
    }
}

class RealClassHandler implements InvocationHandler{


    Object proxyed;

    public RealClassHandler(Object proxyed){
        this.proxyed = proxyed;
    }

    protected void beforeCall(Method method, Object[] args){
        print("Calling " + method.getName());
        print("Whith parameters: ");
        print(args);
    }

    protected void afterCall(Method method, Object[] args){
        print("after call " + method.getName());
        catchFloat(args);
    }

    protected void catchFloat(Object[] args){
        for(Object obj : args){
            print("obj.getClass().iInstance(Float.class) = "
                   + SubRealClass.class.isInstance(obj));
            if(obj instanceof RealClass)
                print("true");
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            beforeCall(method, args);
            return method.invoke(proxyed, args);
        } finally{
            afterCall(method, args);
        }

    }
}

public class TryDynamicProxy {
    public static void main(String... args){
        RealClass rc = new RealClass();
        RealClassHandler rch = new RealClassHandler(rc);
        SomethingDoable proxy = (SomethingDoable) Proxy.newProxyInstance(RealClass.class.getClassLoader(),
                new Class[] {SomethingDoable.class},
                rch);

        proxy.f3(new RealClass(), 55F, 33);

    }

}
