package myutil;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 06.07.17.
 */
public class Hex {
    public static String format(byte[] bytes){
        StringBuffer result = new StringBuffer();
        int n = 0;
        for(byte b : bytes){
            if(n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format(" %02X", b));
            n++;
            if(n%16 == 0){
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String... args){
        print(format("//nasd3$$#2ada sd  sddf f gfdg".getBytes()));
    }
}
