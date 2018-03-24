package myutil;

import java.io.*;

/**
 * Created by nayanzin on 05.08.17.
 */
public class BinaryFile {
    public static byte[] readBinaryFile(File file) {
        byte[] data;
        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(file.getAbsoluteFile())
        );) {
            data = new byte[in.available()];
            in.read(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static byte[] readBinaryFile(String fileName) {
        return readBinaryFile(new File(fileName));
    }

    public static void saveBinaryFile(String fileName, byte[] data) {
        try (BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(new File(fileName).getAbsoluteFile())
        );) {
            out.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
