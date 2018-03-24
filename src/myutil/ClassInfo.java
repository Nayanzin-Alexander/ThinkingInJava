package myutil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 10.07.17.
 */
public class ClassInfo {
    public static void printClass(Class cl){
        print("Class name " + cl.getName());
        print("Class simple name " + cl.getSimpleName());
        print("Class fields: ");
        Field[] fields = cl.getDeclaredFields();
        for(Field field : fields){
            printField(field);
        }

        print("Class Methods: ");
        Method[] methods = cl.getMethods();
        for(Method method : methods){
            printMethod(method);
        }


    }

    public static void printField(Field field){
        print("    " + field.getType().getSimpleName() + "  " + field.getName() + ";");
    }

    public static void printMethod(Method mth){
        print("    " + mth.getReturnType().getSimpleName() + "  " + mth.getName() + ";");
    }
}
