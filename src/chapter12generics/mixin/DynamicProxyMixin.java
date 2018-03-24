package chapter12generics.mixin;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 20.07.17.
 */

class TwoTuple<A,B> {
    public final A first;
    public final B second;
    public TwoTuple(A a, B b) { first = a; second = b; }
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class MixinProxy implements InvocationHandler {

    Map<String, Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object, Class<?>> ... pairs){
        delegatesByMethod = new HashMap<>();
        for(TwoTuple<Object, Class<?>> pair : pairs){
            for(Method method : pair.second.getMethods()){
                String methodName = method.getName();
                // The first interface in the map
                // implements the method.
                if(! delegatesByMethod.containsKey(methodName)){
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstatnce(TwoTuple... pairs){
        Class[] interfaces = new Class[pairs.length];
        for(int i = 0; i < pairs.length; i++){
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(
                cl, interfaces, new MixinProxy(pairs));
    }
}

public class DynamicProxyMixin {
    public static void main(String... args){
        Object mixin = MixinProxy.newInstatnce(
          new TwoTuple(new BasicImp(), Basic.class),
                new TwoTuple(new TimeStampedImp(), TimeStampedImp.class),
                new TwoTuple(new SerialNumberedImp(), SerialNumberedImp.class)
        );

        Basic b = (Basic) mixin;
        TimeStamped t =(TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        print(b.get());
        print(t.getStamp());
        print(s.getSerialNumber());
    }
}
