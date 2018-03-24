package chapter15io;

import java.io.*;

/**
 * Created by nayanzin on 03.08.17.
 */
public class BasicFileOutput {
    static String file = "/home/nayanzin/derby2.log";

    public static void main(String... args) throws IOException{
        BufferedReader in = new BufferedReader(
                new StringReader(ReadText.read()));

        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));

        int lineCount = 0;
        String s;

        while( (s = in.readLine()) != null){
            out.println(++lineCount + ": " + s);
        }
        out.close();
    }
}
