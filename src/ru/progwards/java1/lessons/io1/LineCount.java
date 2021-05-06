/*
Создать статический метод public static int calcEmpty(String fileName), в котором посчитать количество пустых строк
в файле. В случае возникновения ошибок, вернуть -1
 */
package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {

    public static void main(String[] args) {
        String[] fileNames = {null, "file1.txt", "file.txt", "file1.bin"};
        for (int i = 0; i < 4; i++) {
            System.out.println("Имя файла " + fileNames[i]);
            System.out.println("Количество пустых строк в файле " + calcEmpty(fileNames[i]));
            System.out.println();
        }
    }

    public static int calcEmpty(String fileName) {
        int count = -1;
        if (fileName != null) {
            try {
                FileReader fileReader = new FileReader(fileName);
                try {
                    Scanner scanner = new Scanner(fileReader);
                    count = 0;
                    while (scanner.hasNextLine()) {
                        String anyString = scanner.nextLine();
                        if (anyString.isEmpty())
                            count++;
                    }
                } finally {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println("Нет файла с таким именем на устройстве!");
            }
        }
        return count;
    }
}

