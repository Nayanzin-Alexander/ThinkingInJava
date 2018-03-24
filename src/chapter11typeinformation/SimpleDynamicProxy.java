package chapter11typeinformation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.07.17.
 */

    class DynamicProxyHandler implements InvocationHandler {
        private Object proxied;

        public DynamicProxyHandler(Object proxied){
            this.proxied = proxied;
        }

        public void ActionBeforeInvoke(){
            print("Action before invoke");
        }

        public void ActionAfterInvoke(){
            print("Action after invoke");
        }

        public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable{
            System.out.println("**** proxy: " + proxy.getClass() +
                    ", method: " + method + ", args: " + args);
            if(args != null)
                for(Object arg : args)
                    System.out.println(" " + arg);
            ActionBeforeInvoke();
            try {
                return method.invoke(proxied, args);
            }
            finally{
                ActionAfterInvoke();
            }
        }
    }

public class SimpleDynamicProxy {

        public static void consumer(Interface iface){
            iface.doSomething();
            iface.doSomethingElse("bobob");
        }

        public static void main(String... args){
            RealObject real = new RealObject();
            consumer(real);

            //Insert proxy and call again
            Interface proxy = (Interface) Proxy.newProxyInstance(
                    Interface.class.getClassLoader(),
                    new Class[]{Interface.class},
                    new DynamicProxyHandler(real));
            consumer(proxy);
        }
}
