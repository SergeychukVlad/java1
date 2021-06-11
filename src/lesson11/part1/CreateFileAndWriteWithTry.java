package lesson11.part1;

import java.io.FileWriter;
import java.io.IOException;

/*
Внутри функции (за одно её исполнение) может быть сгенерировано БОЛЕЕ ОДНОГО исключения.
Но пробросить наверх можно только ОДНО.
Все остальные исключения называются ПОДАВЛЕННЫМИ.
 */
public class CreateFileAndWriteWithTry {
    public static void createFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, false);
        try {
            writer.write("Какая-то строка");
        } finally {
            writer.close();
        }
    }

    public static void main(String[] args) {
        try {
            createFile("????");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
