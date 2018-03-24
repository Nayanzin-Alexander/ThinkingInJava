package chapter15io.serialization;

import java.io.*;
import java.util.Date;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 08.08.17.
 */
public class Logon implements Serializable {

    public Date date = new Date();
    public String login;
    transient  public String passwd;
    public Logon(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }
    @Override
    public String toString() {
        return String.format("%s %s %s", date, login, passwd);
    }
    //@Override
    private void writeObject(ObjectOutputStream out)
        throws IOException {
        print("writeExternal");
        out.defaultWriteObject();
    }

    public static void main(String... args)
        throws IOException, ClassNotFoundException {
        Logon logon = new Logon("Sasha", "123456");
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("logon.txt"));
        out.writeObject(logon);
        out.writeObject(logon);
        out.writeObject(logon);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("logon.txt"));
        Object obj;
        while(true) {
            try {
                obj = in.readObject();
                print(obj); // Polymorphic call.
            } catch (Exception e) {
                break;
            }
        }
        in.close();
    }
}
