package junittutorial.example1;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 25.08.17.
 */
public class MessageUtil {
    private String message;

    // Constructor
    // @param message to be printed
    public MessageUtil(String message) {
        this.message = message;
    }

    // Prints the message
    public String printMessage() {
        print(message);
        return message;
    }
}
