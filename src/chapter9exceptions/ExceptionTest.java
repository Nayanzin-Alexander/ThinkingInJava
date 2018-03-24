package chapter9exceptions;

import myutil.MyException;

import static myutil.MyException.logException;
import static myutil.Printer.print;

/**
 * Created by nayanzin on 04.07.17.
 */
public class ExceptionTest {
    public void f() throws MyException{
        throw new MyException("ExceptionTest", "Testing my exception");
    }
    public static void main(String... args){
        try{
            Integer i = null;
            i.toString();
        } catch (NullPointerException e){
            logException(e);
            print("getMessage " + e.getMessage());
            print("getLocalizedMessage " + e.getLocalizedMessage());
            print("getCause " + e.getCause());
            print("getStackTrace " + e.getStackTrace());
        }

    }
}
