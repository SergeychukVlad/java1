package lesson11.part2;
/*
Информация о файле или каталоге
 */

import java.io.File;
import java.util.Date;

public class SimpleFileInfo {
    public static void main(String[] args) {
        final String fs = System.getProperty("file.separator");
        File fileInfo = new File("D:" + fs + "Progwards" + fs + "src" + fs + "lesson11" + fs + "part2" + fs + "Intro");
        System.out.println("exists: " + fileInfo.exists());
        System.out.println("canExecute: " + fileInfo.canExecute());
        System.out.println("lastModified: " + new Date(fileInfo.lastModified()));
        System.out.println("length: " + fileInfo.length());
        System.out.println("getParent: " + fileInfo.getParent());
        System.out.println("getPath: " + fileInfo.getPath());
        System.out.println("getName: " + fileInfo.getName());
        System.out.println("isDirectory: " + fileInfo.isDirectory());
        System.out.println("isFile: " + fileInfo.isFile());
        System.out.println("isHidden: " + fileInfo.isHidden());
    }
}
