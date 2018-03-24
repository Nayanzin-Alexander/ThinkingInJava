package chapter10string;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 06.07.17.
 */
public class Rudolph {
    public static void main(String... args) {
        String[] patterns = new String[]{ "Rudolph",
                    "[rR]udolph",
                    "[rR][aeiou][a-z]ol.*",
                    ".*"};
        for(String pattern : patterns){
            print("Rudolph".matches(pattern));
        }


        print(patterns);
    }
}
