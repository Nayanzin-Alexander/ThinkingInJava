package myutil;

import org.omg.SendingContext.RunTime;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


import static myutil.Printer.print;

/**
 * Created by nayanzin on 04.08.17.
 */
public class TextFile extends ArrayList<String> {

    // Read a file as a single String
    public static String read(String fileName){
        StringBuffer buffer = new StringBuffer();

        try (BufferedReader in = new BufferedReader(
                new FileReader(new File(fileName).getAbsoluteFile()));) {
            String line;
            while ((line = in.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return buffer.toString();
    }

    // Write a single file in one method call
    public static void write(String fileName, String text) {
        try(PrintWriter out = new PrintWriter(
                new File(fileName).getAbsoluteFile())) {
            out.print(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Constructors:

    // Read a file, split by any regular expression:
    public TextFile(String fileName, String regex) {
        super(Arrays.asList(read(fileName).split(regex)));
        if(get(0).equals("")){
            remove(0);
        }
    }

    // Normally read by lines
    public TextFile(String fileName) {
        this(fileName, "/n");
    }

    // write text to file
    public void write(String fileName){
        try(PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());) {
            for(String line : this){
                out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String... args) {
        String fileName = "/home/nayanzin/textFile";
        write(fileName, "Hello hello hello");
        print(read(fileName));
        TextFile textFile = new TextFile(fileName);
        print(textFile);
        textFile.write("/home/nayanzin/textFile");
    }
}
