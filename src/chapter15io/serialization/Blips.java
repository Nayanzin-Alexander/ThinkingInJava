package chapter15io.serialization;

import java.io.*;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 08.08.17.
 */

class Blip1 implements Externalizable {
    public Blip1() {
        print("Blip1 constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException{
        print("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    public Blip2() {
        print("Blip2 constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException{
        print("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String... args)
        throws IOException, ClassNotFoundException {
        print("Construction objects");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();

        print("Saving objects");
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("blip.txt"));
        out.writeObject(b1);
        out.writeObject(b2);
        out.close();

        print("Read objects");
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("blip.txt"));
        b1 = (Blip1) in.readObject();
        b2 = (Blip2) in.readObject();
        in.close();
    }

}
