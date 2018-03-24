package chapter14containersindepth.hashcode;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 28.07.17.
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type)
        throws Exception{
        Constructor<T> constructor = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for(int i=0; i<10; i++) {
            map.put(constructor.newInstance(i), new Prediction());
        }
        print(map);
        Groundhog groundhog = constructor.newInstance(3);
        Prediction prediction = map.get(groundhog);
        if(prediction != null)
            print("Predicton from " + groundhog + "= " + prediction);
        else
            print("Prediction from " + groundhog + " not found");
    }
    public static void main(String... args) throws Exception{
        detectSpring(Groundhog2.class);
    }
}
