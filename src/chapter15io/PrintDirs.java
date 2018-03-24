package chapter15io;

import java.io.File;

import static myutil.Printer.print;

/**
 * Created by nayanzin on 02.08.17.
 */

public class PrintDirs {

    public static void printDir(File dir){
        printDir(dir, 1, "");
    }

    private static void printDir(File dir, int level, String fileOffset){
        if(dir == null)
            return;
        print(dirOffset(level) + "-" + dir.getName());

        File[] files = dir.listFiles();
        if(files == null || files.length == 0)
            return;
        for(File file : files) {
            if (file.isDirectory()) {
                printDir(file, level+1, fileOffset.concat("   "));
            }
        }
        for(File file : files) {
            if (!file.isDirectory()) {
                print(dirOffset(level) + "---" + file.getName());
            }
        }
    }

    private static String dirOffset(int level){
        int offset = level * 5;
        return String.format("%" + offset + "s|","");
    }

    public static void main(String... args){
        File startDir = new File("/home/nayanzin/Desktop/");
        printDir(startDir);

    }
}
