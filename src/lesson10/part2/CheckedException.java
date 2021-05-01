package lesson10.part2;

import java.io.FileWriter;
import java.io.IOException;

public class CheckedException {
    public static void checkException() {
        try {
            FileWriter writer = new FileWriter("?????", false);
            try {
                writer.write("какая-то строка");
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void createFile(String fileName) throws IOException {
        // throws example
        FileWriter writer = new FileWriter(fileName, false);
        writer.close();
    }

    public static void main(String[] args) {
        checkException();
        // try-catch example
        try {
            createFile("?????");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
