package chapter15io.serialization;

import sun.security.provider.SHA;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 08.08.17.
 */
public class RecoverCADState {
    public static void main(String... args)
        throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("CADState.dat"));

        // Read in the same order they were written:
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        List<Shape> shapes = (List<Shape>) in.readObject();
        in.close();


        print(shapes);
    }
}
