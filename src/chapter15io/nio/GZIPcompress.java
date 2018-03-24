package chapter15io.nio;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 07.08.17.
 */
public class GZIPcompress {
    public static void main(String... args)
    throws IOException{
        String inFile = "data.txt";
        String outFile = "data.gzip";

        BufferedReader in = new BufferedReader(
                new FileReader(inFile));
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream(outFile)));
        int c;
        while( (c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();

        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(
                        new FileInputStream(outFile))));
        String s;
        while ( (s = in2.readLine()) != null)
            print(s);
    }
}
