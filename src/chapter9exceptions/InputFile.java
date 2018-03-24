package chapter9exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 05.07.17.
 */
public class InputFile {
    private BufferedReader in;

    public InputFile(String fileName) throws Exception{
        try{
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e){
            print("Could not open " + fileName);
            // Couldn't open so couldn't close it
            throw e;
        } catch(Exception e){
            // All other exception should close file
            try{
                in.close();
            } catch (IOException ioe){
                print("Closing file is unsuccessful");
            }
            throw e;
        } finally{
            //don't close file here. Close in corresponding exception
        }
    }

    public String getLine(){
        String s;
        try{
            s = in.readLine();
        } catch (IOException ioe){
            throw new RuntimeException("in.readLine failed");
        }
        return s;
    }

    public void dispose(){
        try{
            in.close();
            print("File was closed correctly");
        } catch (IOException ioe){
            throw new RuntimeException("in.close() failed");
        }
    }




}
