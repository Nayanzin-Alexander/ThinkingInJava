package myutil;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by nayanzin on 04.07.17.
 */
public class MyException extends Exception {
    private String level;
    private static Logger logger = Logger.getLogger("MyException");

    public MyException(String level, String message){
        super(message);
        this.level = level;
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public String getMessage(){
        return "MyException at " + level + " with message: " + super.getMessage();
    }

    public static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
