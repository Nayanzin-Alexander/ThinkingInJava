package chapter15io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 03.08.17.
 */
public class FormattedMemoryInput {
    public static void main(String... args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(
                new ByteArrayInputStream(ReadText.read().getBytes()));
        try{
            while(true) {
                print( (char) dataInputStream.readByte());
            }
        } catch (EOFException e){
            print("End of stream");
        }

        try{
            while(dataInputStream.available() != 0) {
                print( (char) dataInputStream.readByte());
            }
        } catch (EOFException e){
            print("End of stream");
        }
    }
}
