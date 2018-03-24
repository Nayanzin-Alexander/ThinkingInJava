package chapter15io;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by nayanzin on 02.08.17.
 */
public class DirList {
    public static FilenameFilter filter(final String regex) {
// Creation of anonymous inner class:
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        }; // End of anonymous inner class
    }
    public static void main(String[] args) {
        File path = new File(".");
        path.listFiles();

        String[] list;
        final String regex1 = ".idea";
        String regex2 = ".idea";
        list = path.list((file, name) -> {
            Pattern pattern = Pattern.compile(regex2);
            return pattern.matcher(name).matches();
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}
