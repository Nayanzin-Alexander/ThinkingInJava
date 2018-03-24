package chapter12generics.mixin;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 21.07.17.
 */

class MyProxy implements InvocationHandler{
    private Map<String, Object> methodDelegates;

    //Concstructor
    public MyProxy(TwoTuple<Object, Class<?>>... tuples){

        methodDelegates = new HashMap<>();

        //Loop through objects and it's methods and fill methodDelegates map
        for(TwoTuple<Object, Class<?>> tuple : tuples){
            Object object = tuple.first;
            Class<?> objectClass = tuple.second;
            Method[] objectMethods = object.getClass().getMethods();
            for(Method method : objectMethods){
                String methodName = method.getName();
                methodDelegates.put(methodName, object);
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object methodDelegate = methodDelegates.get(methodName);
        if(methodDelegate != null){
            return method.invoke(methodDelegate, args);
        } else{
            return null;
        }
    }

    public static Object newInstatnce(TwoTuple<Object, Class<?>>... pairs){
        int pairsCount = pairs.length;
        Class[] interfaces = new Class[pairsCount];
        for(int i=0; i<pairsCount; i++){
            interfaces[i] = pairs[i].second;
        }

        ClassLoader cl = pairs[0].second.getClass().getClassLoader();

        return Proxy.newProxyInstance(cl,
                interfaces,
                new MyProxy(pairs));
    }
}

public class DynamicProxyMixin2 {
    public static void main(String... args){
        Object mixin = MyProxy.newInstatnce(new TwoTuple<>(new String("123"), CharSequence.class),
                new TwoTuple<>(new ArrayList<Integer>(), List.class));
        List<Integer> treatAsCollection = (List) mixin;
        for(int i=0; i<10; i++){
            treatAsCollection.add(i*i);
        }
        treatAsCollection.add(treatAsCollection.get(1) + treatAsCollection.get(2));
        print(treatAsCollection);

        CharSequence treatAsCharSequence = (CharSequence) mixin;

    }
}
