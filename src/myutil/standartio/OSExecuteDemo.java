package myutil.standartio;

/**
 * Created by nayanzin on 05.08.17.
 */
public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("javap myutil.standartio.OSExecuteDemo");
        OSExecute.command("ls -l");
    }
}
