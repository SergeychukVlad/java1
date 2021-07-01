/*
Класс Censor.
Создать статический метод public static void censorFile(String inoutFileName, String[] obscene), в котором прочитать
файл inoutFileName и заменить слова, содержащиеся в String[] obscene на '*', соответствующие количеству символов
в слове, изменения записать в исходный файл. В случае возникновения ошибки, выбросить свое собственное исключение
CensorException в котором сохранить - строку, полученную у оригинального exception через метод getMessage()
и имя файла, в котором возникла ошибка. В классе перекрыть метод toString(), вернув <имя файла>:<строка ошибки>.
Класс CensorException разместить в классе Censor

Например файл содержит:
Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
obscene = {"Java", "Oracle", "Sun", "Microsystems"}

Должен выдать результат:
**** — строго типизированный объектно-ориентированный язык программирования, разработанный компанией *** ************ (в последующем приобретённой компанией ******).
 */
package ru.progwards.java1.lessons.io2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Censor {

    private static char getSymbol(char symbol) {
        char[] punctuationSymbols = {' ', ',', '-', ':', '.', '!', '?', '\r', '\n'};
        for (char punctuationSymbol : punctuationSymbols) {
            if (symbol == punctuationSymbol) break;
        }
        return symbol;
    }

    private static String getStarsWord(String[] obscene, String[] stars, String separateWord) {
        for (int j = 0; j < obscene.length; j++) {
            if (separateWord.equals(obscene[j])) {
                separateWord = stars[j];
                break;
            }
        }
        return separateWord;
    }


    public static void censorFile(String inoutFileName, String[] obscene) {
        // сделали массив-клон со звездочками вместо символов оригинального obscene[]
        String[] stars = obscene.clone();
        for (int i = 0; i < stars.length; i++) {
            stars[i] = "*".repeat(stars[i].length());
        }

        String sentence = "";
        StringBuilder separateWord = new StringBuilder();

        File file = new File(inoutFileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                sentence = scanner.nextLine();
                System.out.println(sentence);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }

        StringBuilder result = new StringBuilder();
        char[] charsOfSentence = sentence.toCharArray();
        for (int i = 0; i < charsOfSentence.length; i++) {
            if (Character.isLetter(charsOfSentence[i])) {
                separateWord.append(charsOfSentence[i]);

                // если строка не заканчивается знаком препинания (или \r), то "ловим" слово на индексе окончания строки
                if (i == charsOfSentence.length - 1) {
                    result.append(getStarsWord(obscene, stars, separateWord.toString()));
                }
            } else {
                result.append(getStarsWord(obscene, stars, separateWord.toString())).append(getSymbol(charsOfSentence[i]));
                separateWord = new StringBuilder();
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String[] obscene = {"Java", "Class", "Library", "Synchronized", "Accessor"};
        censorFile("D:\\Progwards\\src\\ru\\progwards\\java1\\lessons\\io2\\hw_lesson11_task3", obscene);
    }
}
