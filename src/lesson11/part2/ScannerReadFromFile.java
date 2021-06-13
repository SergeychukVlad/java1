package lesson11.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Scanner. Чтение из файла
 */
public class ScannerReadFromFile {
    public static void main(String[] args) {
        File file = new File("D:\\Progwards\\src\\lesson11\\part2\\Intro");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }
    }
}
