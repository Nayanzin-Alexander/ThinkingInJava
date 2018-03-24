package chapter17annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 20.08.17.
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for(Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc != null) {
                print("Found use Case: " + uc.id() +
                " " + uc.description());
                useCases.remove(new Integer(uc.id())); // remove(Object) not index
            }
        }

        for(int i : useCases) {
            print("Warring: missing use case - " + i);
        }
    }

    public static void main(String... args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47,48,49,50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
