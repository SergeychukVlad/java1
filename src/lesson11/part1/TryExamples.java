package lesson11.part1;

import java.io.FileWriter;
import java.io.IOException;

public class TryExamples {
    static void tryCatch() {
        try {
            FileWriter writer = new FileWriter("????", false);
            writer.write("something else...");
            writer.close();
            // если что-то упадёт, этот оператор не выполнится никогда.
            // файл останется открытым-заблокированным
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void tryWithResources() {
        try (FileWriter writer = new FileWriter("????", false)) {
            writer.write("something else...");
            // writer.close() будет вызван автоматически
            // и файл НЕ останется открытым-заблокированным
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // какие-то действия
            // это тоже вполне допустимо
        }
    }

    public static void main(String[] args) {
        tryCatch();
        tryWithResources();
    }
}
