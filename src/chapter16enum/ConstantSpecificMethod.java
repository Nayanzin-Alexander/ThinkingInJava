package chapter16enum;

import java.text.DateFormat;
import java.util.Date;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 14.08.17.
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        // Describing the method
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
        String getInfo() {
            return System.getProperty("CLASSPATH");
        }
    },

    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String... args) {
        for(ConstantSpecificMethod e : values()){
            print(e.getInfo());
        }
    }
}
