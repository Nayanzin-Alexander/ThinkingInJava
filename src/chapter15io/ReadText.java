package chapter15io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nayanzin on 02.08.17.
 */
public class ReadText {
    public static String read() throws IOException {
        return read("/home/nayanzin/derby.log");
    }

    public static String read(String fileName) throws IOException {
        StringBuffer result = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            result.append(line + "\n");
        }
        br.close();
        return result.toString();
    }

    public static void main(String[] args)
            throws IOException {
        System.out.print(read("/home/nayanzin/derby.log"));
    }
}
