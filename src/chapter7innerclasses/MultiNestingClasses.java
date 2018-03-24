package chapter7innerclasses;

import static myutil.Printer.*;

/**
 * Created by nayanzin on 30.06.17.
 */
class A2{
    public void a() {
        print("a()");
    }
    class B{
        public void b() {
            print("b()");
        }
        class C{
            public void c(){
                print("c()");
            }
        }
    }
}


public class MultiNestingClasses {
    public static void main(String... args){
        A2 a = new A2();
        a.a();
        a.new B().b();
        a.new B().new C().c();
    }
}
