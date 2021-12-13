/*
Реализовать класс, считывающий содержимое файла и возвращающего набор букв, которые встречались в этом файле.
Буквы, это латинские [A..Z[ и [a..z] и русские [А..Я] и [а..я], остальные символы надо игнорировать

3.1 Метод public static String process(String fileName) - вернуть все буквы, которые встретились в файле,
сконкатенированные в виде строки. Буквы должны быть упорядочены по алфавиту, типа “ADEF...”.
се возникающие исключения, по работе с потоками, пробросить выше.
 */
package ru.progwards.java1.lessons.sets;

import java.io.*;

public class LettersInFile {


    public static String process(String fileName) throws IOException {
        if (fileName != null) {
            try {
                FileReader reader = new FileReader(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {

            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
