package unittest;

import myutil.BinaryFile;
import myutil.Directory;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 21.08.17.
 */
public class ClassNameFinder {

    // This method returns something...String
    public static String thisClass(byte[] classBytes) {
        Map<Integer, Integer> offsetTable = new HashMap<>();
        Map<Integer, String> classNameTable = new HashMap<>();

        try{
            DataInputStream data = new DataInputStream(new ByteArrayInputStream(classBytes));

            int magic = data.readInt();  // 0xcafebabe
            int minorVersion = data.readShort();
            int majorVersion = data.readShort();
            int constant_pool_count = data.readShort();
            int[] constant_pool = new int[constant_pool_count];
            for(int i = 1; i < constant_pool_count; i++) {
                int tag = data.read();
                int tableSize;
                switch (tag) {
                    case 1: // UTF
                        int length = data.readShort();
                        char[] bytes = new char[length];
                        for(int k = 0; k < length; k++)
                            bytes[k] = (char) data.read();
                        String className = new String(bytes);
                        classNameTable.put(i, className);
                        break;
                    case 5: // LONG
                    case 6: // DOUBLE
                        data.readLong(); //discard 8 bytes
                        i++; // Special skip necessary
                        break;
                    case 7: // CLASS
                        int offset = data.readShort();
                        offsetTable.put(i, offset);
                        break;
                    case 8: // STRING
                        data.readShort(); // discard 2 bytes
                        break;
                    case 3: // INTEGER
                    case 4: // FLOAT
                    case 9: // FIELD_REF
                    case 10: // METHOD_REF
                    case 11: // INTERFACE_METHOD_REF
                    case 12: // NAME_AND_TYPE
                    case 18: // InvokeDynamic
                        data.readInt(); // discard 4 bytes;
                        break;
                    case 15: // Method handle
                        // skip 3 bytes
                        data.readShort();
                        data.readByte();
                        break;
                    case 16: // Method type
                        // skip 2 bytes
                        data.readShort();
                    break;
                    default:
                        throw new RuntimeException(i+ " Bad tag " + tag);
                }
            }
            short access_flags = data.readShort();
            int this_class = data.readShort();
            int super_class = data.readShort();
            return classNameTable.get(offsetTable.get(this_class)).replace('/', '.');
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String parceClassNameFromClassPath(String path) {
        String regex = "[^/]+.class";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(path);
        while(matcher.find()){
            print(matcher.group());
        }
        return "";
    }

    // Demonstration
    public static void main(String... args) {
        if(args.length > 0) {
            for(String arg : args) {
                print("\nReading " + arg);
                print(thisClass(BinaryFile.readBinaryFile(arg)));
            }
        } else {
            // Walk the entire tree:
            for(File klass : Directory.walk(".", ".*\\.class")) {
                print("\nReading " + klass);
                parceClassNameFromClassPath(klass.toString());
                print(thisClass(BinaryFile.readBinaryFile(klass)));
                break;
            }
        }
    }
}
