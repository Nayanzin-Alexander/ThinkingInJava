package chapter15io.serialization;

import java.io.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 08.08.17.
 */
public class Bleep3 implements Externalizable {
    private int i;
    private String s; //No initialization
    public Bleep3() {
        print("Blip3 constructor:");
    }
    public Bleep3(String x, int a) {
        s = x;
        i = a;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Bleep3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Bleep3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String... args)
    throws IOException, ClassNotFoundException {
        print("Constructing object");
        Bleep3 b3 = new Bleep3("A String ", 47);
        print(b3);

        print("Saving objects");
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("beep3.txt"));
        out.writeObject(b3);
        out.close();

        print("Reading object");
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("beep3.txt"));
        Object obj = in.readObject();
        Bleep3 b4 = (Bleep3) obj;
        print(b4);
    }
}
