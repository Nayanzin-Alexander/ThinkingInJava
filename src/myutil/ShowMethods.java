package myutil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 11.07.17.
 */
public class ShowMethods {

    private static String usage = "usage:\n" +
        "ShowMethods qualified.class.name\n" +
        "To show all methods in class or:\n" +
        "ShowMethods qualified.class.name word\n" +
        "To search for methods involving ‘word’";
    private static Pattern pattern = Pattern.compile("\\w+\\."); //this means any word ending whith dot
    //full package name f.e.

    public static void main(String... args){

        String[] newArgs = {
                "myutil.ShowMethods",
                //"has"
        };

        args = newArgs;

        if(args.length < 1) {
            print(usage);
            System.exit(0);
        }

        int lines = 0;
        try{
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] constructors = c.getConstructors();
            if(args.length == 1) {
                for (Method method : methods) {
                    print(pattern.matcher(method.toString()).replaceAll(""));
                    print(pattern.matcher(method.toString()).replaceAll(""));
                    print(method);
                    print();
                }

                for (Constructor constructor : constructors) {
                    print(pattern.matcher(constructor.toString()).replaceAll(""));
                }

                lines = methods.length + constructors.length;
            } else {
                for(Method method : methods)
                    if(method.toString().indexOf(args[1]) != -1) {
                        print(pattern.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                for(Constructor constructor : constructors)
                    if(constructor.toString().indexOf(args[1]) != -1) {
                        print(pattern.matcher(constructor.toString()).replaceAll(""));
                        lines++;
                    }
            }

        }catch(ClassNotFoundException e) {
            print("No such class: " + e);
        }
    }
}
