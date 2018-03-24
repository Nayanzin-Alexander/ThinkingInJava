package chapter9exceptions;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 04.07.17.
 */
public class Rethrowing {
    public static void a() throws Exception{
        print("Inside f()");
        throw new Exception();
    }

    public static void b() throws Exception{
        try{
            a();
        } catch(Exception e){
            print("Inside b() " + e.getStackTrace());
            throw e;
        }
    }

    public static void c() throws Exception{
        try{
            a();
        } catch (Exception e){
            print("Inside c() " + e.getStackTrace());
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            b();
        } catch(Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        try {
            c();
        } catch(Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
