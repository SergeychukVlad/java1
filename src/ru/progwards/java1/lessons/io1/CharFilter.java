/*
Создать статический метод public static void filterFile(String inFileName, String outFileName, String filter), в котором
прочитать файл inFileName и удалить символы, содержащиеся в String filter, результат записать в выходной файл.
В случае возникновения ошибки, пробросить стандартное исключение выше, корректно закрыв все ресурсы
Например файл содержит:
Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems
(в последующем приобретённой компанией Oracle).
obscene = " -,.()"
Должен выдать результат:
JavaстроготипизированныйобъектноориентированныйязыкпрограммированияразработанныйкомпаниейSunMicrosystemsвпоследующемприобретённойкомпаниейOracle
*/
package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) {
        String strFromFile = "";
        String strToFile = "";

        try {
            FileReader fileReader = new FileReader(inFileName);
            try {
                Scanner scanner = new Scanner(fileReader);
                while (scanner.hasNextLine()) {
                    strFromFile = scanner.nextLine();
                }
            } finally {
                fileReader.close();
            }
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("Cannot find file " + inFileName);
        }

        System.out.print("Из этой строки : ");
        System.out.println(strFromFile);
        System.out.print("Удаляем символы: ");
        System.out.println(filter);

        if (filter == null || filter.equals("")) {
            strToFile = strFromFile;
        } else {

            boolean jump = false;
            for (int i = 0; i < strFromFile.toCharArray().length; i++) {
                for (int j = 0; j < filter.toCharArray().length; j++) {
                    if (strFromFile.charAt(i) == filter.charAt(j)) {
                        jump = true;
                        break;
                    }
                }
                if (!jump) {
                    strToFile = strToFile + strFromFile.charAt(i);
                }
                jump = false;
            }
        }
        System.out.println("Результат: " + strToFile);

        try {
            FileWriter fileWriter = new FileWriter(outFileName);
            try {
                fileWriter.write(strToFile);
            } finally {
                fileWriter.close();
            }
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("Cannot create file " + outFileName);
        }
    }

    public static void main(String[] args) {
        try {
            filterFile("file4filtering.txt", null, "-,. ()");
            filterFile("file4filtering.txt", "filteredfile.txt", null);
            filterFile("file4filtering.txt", "filteredfile.txt", "-,. ()");
            filterFile(null, null, null);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

