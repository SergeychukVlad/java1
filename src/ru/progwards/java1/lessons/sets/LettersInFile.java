/*
Реализовать класс, считывающий содержимое файла и возвращающего набор букв, которые встречались в этом файле.
Буквы, это латинские [A..Z[ и [a..z] и русские [А..Я] и [а..я], остальные символы надо игнорировать

3.1 Метод public static String process(String fileName) - вернуть все буквы, которые встретились в файле,
сконкатенированные в виде строки. Буквы должны быть упорядочены по алфавиту, типа “ADEF...”.
Все возникающие исключения, по работе с потоками, пробросить выше.
 */
package ru.progwards.java1.lessons.sets;

import java.io.*;
import java.util.*;

public class LettersInFile {

    public static String process(String fileName) {
        StringBuilder result = new StringBuilder();
        Set<Character> characters = new HashSet<>();

        if (fileName != null) {
            try {
                File file = new File(fileName);
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                char[] chars;

                do {
                    line = reader.readLine();
                    if (line == null) break;

                    chars = line.toCharArray();
                    for (char aChar : chars) {
                        if (Character.isAlphabetic(aChar))
                            characters.add(aChar);
// http://proglang.su/java/characters-isletter
//                        if (aChar >= 65 && aChar <= 90
//                                || aChar >= 97 && aChar <= 122
//                                || aChar == 1025    // Ё
//                                || aChar == 1105    // ё
//                                || aChar >= 1040 && aChar <= 1103) {
//                            characters.add(aChar);
//                        }
                    }
                } while (chars.length > 0);
            } catch (FileNotFoundException e) {
                System.out.println("LettersInFile(). File: " + fileName + " " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else throw new NullPointerException();

        TreeSet<Character> sortedChars = new TreeSet<>(characters);
        for (Character sortedChar : sortedChars) {
            result.append(sortedChar);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String fileName = "D:\\Progwards\\java1\\src\\ru\\progwards\\java1\\lessons\\sets\\lesson13";
        System.out.println(process(fileName));
    }
}
/*
ЁПабвгдежзийклмнопрстуфхцчшщъыьэюяё - изначальный вариант
ЁПабвгдежзийклмнопрстуфхцчшщъыьэюяё - isLetter()
ЁПабвгдежзийклмнопрстуфхцчшщъыьэюяё - isAlphabetic()
 */
