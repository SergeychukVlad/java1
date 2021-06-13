package lesson11.part2;

import java.io.File;

/*
Создание цепочки вложенных каталогов
 */
public class IO_makeDirs {
    public static void createDirs(File file) {
        if (file.mkdirs())
            System.out.println("Цепь каталогов создана");
        else
            System.out.println("Цепь каталогов создать НЕ УДАЛОСЬ!");
    }

    public static void deleteDirs(File file) {
        if (file.exists())
            file.delete();
        else
            System.out.println("Цепь каталогов удалить НЕ УДАЛОСЬ!");
    }

    public static void main(String[] args) {
        File file = new File("D:\\Progwards\\src\\lesson11\\part2\\NewDir");
        createDirs(file);
        deleteDirs(file);
    }
}
