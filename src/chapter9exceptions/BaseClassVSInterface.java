package chapter9exceptions;

/**
 * Created by nayanzin on 05.07.17.
 */

class BaseException extends Exception{}
class InterfaceException extends Exception{}
class AnotherException extends Exception{}

abstract class Base{
    public void f() throws BaseException {}
    public abstract void g() throws BaseException;
}

interface Inter{
    //void f();// throws InterfaceException;
}

public class BaseClassVSInterface extends Base
    implements Inter{

    //Its ok
    //@Override
   // public void f(){}

    //Problem. Method clushes
    //@Override
    public void f() throws BaseException{}

    //Problem. Method clushes
    //@Override
    //!public void f() throws InterfaceException {}

    public void g() throws BaseException{}

}
