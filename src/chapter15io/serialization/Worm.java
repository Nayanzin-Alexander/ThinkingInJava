package chapter15io.serialization;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 07.08.17.
 */

class Data implements Serializable {
    private int n;
    public Data(int n){
        this.n = n;
    }
    @Override
    public String toString() {
        return Integer.toString(n);
    }
}

public class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;

    // Value of i == number of segments
    public Worm(int i, char x) {
        print("Worm constructor: " + i);
        c = x;
        if (--i > 0)
            next = new Worm(i, (char) (x+1));
    }

    public Worm() {
        print("Default worm constructor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(c);
        result.append('(');
        for(Data data : d)
            result.append(data);
        result.append(')');
        if(next != null)
            result.append(next);

        return result.toString();
    }

    public static void main(String... args)
        throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        print("w = " + w);
        List<Worm> list = new ArrayList<>();
        list.add(w);
        list.add(w);
        // Save worm to the file
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("data.dat"));
        out.writeObject(list);
        out.writeObject("Worm storage");
        out.writeObject(w);
        out.close();

        // Read worm from the file
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("data.dat"));
        print( (List) in.readObject());
        print( (String) in.readObject());
        print( (Worm) in.readObject());
    }
}
