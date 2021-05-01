package lesson10.part2;

import java.io.FileWriter;
import java.io.IOException;

public class ThrowException {
    // пример трансляции исключений. Важно! Обработать проверяемое исключение.
    // Создать непроверяемое (throw new...) и дальше оно будет проброшено автоматом.
    public static void createFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Невозможно создать файл " + fileName);
        }
    }

    public static void main(String[] args) {
        try {
            createFile("???????");
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
