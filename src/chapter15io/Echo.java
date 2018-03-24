package chapter15io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 05.08.17.
 */
public class Echo {
    public static void main(String... args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out, true);
        PrintWriter error = new PrintWriter(System.err, true);
        String s;
        while( (s = in.readLine()) != null && s.length() != 0) {
            out.println(s);
            error.println(s);
        }
    }
}
