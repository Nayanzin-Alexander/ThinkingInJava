package chapter11typeinformation;

import myutil.HiddenClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 12.07.17.
 * Exercise 25: (2) Create a class containing private, protected and package-access
 * methods. Write code to access these methods from outside of the class’s package.
 */

public class Exersice25 {

    //All right
    public static void main(String... args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        HiddenClass hidden = new HiddenClass();

        print("Fields: ");
        for(Field field : hidden.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                print(field.get(hidden));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        print("\n\nMethods: ");
        for(Method method : hidden.getClass().getDeclaredMethods()){
            method.setAccessible(true);
            print(method);

            Parameter[] parameters = method.getParameters();
            Object[] arguments = new Object[parameters.length];
            for(int i=0; i<parameters.length; i++){
                Class<?> type = parameters[i].getType();
                Object obj = type.cast(type.newInstance());

                arguments[i] = obj;
            }
            print("Invoking " + method.invoke(hidden, arguments));
        }
    }
}
