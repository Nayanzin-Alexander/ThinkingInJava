package unittest.examples;

import java.io.File;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 24.08.17.
 */
public class Example2 {
    public static void main(String... args) {
        print("Example2");
        if(args.length > 0) {
            String fileName = args[0];
            File file = new File(fileName);
            print("File " + fileName + " exists: " + file.exists());
        }

    }
}
