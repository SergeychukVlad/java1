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

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Censor {
    class CensorException extends Throwable {
        private String errorCode;

        public CensorException(String fileName, String errorCode) {
            super(fileName);
            this.errorCode = errorCode;
        }

        @Override
        public String toString() {
            return super.getClass() + ":" + errorCode;
        }
    }

    private static RandomAccessFile raf;

    public static synchronized RandomAccessFile getInstance(String fileName, String mode) {
        if (raf == null) {
            try {
                raf = new RandomAccessFile(new File(fileName), mode);
            } catch (FileNotFoundException notFoundException) {
                notFoundException.printStackTrace();
            }
        }
        return raf;
    }

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

    private static String getSentence(String inoutFileName) {
        String sentence = "";
        raf = getInstance(inoutFileName, "rw");
        try {
            sentence = raf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(sentence.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    private static void writeUpdatedSentence(String inoutFileName, String updatedSentence) {
        raf = getInstance(inoutFileName, "rw");
        try {
            raf.seek(0);
            raf.write(updatedSentence.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene) {
        // сделали массив-клон со звездочками вместо символов оригинального obscene[]
        String[] stars = obscene.clone();
        for (int i = 0; i < stars.length; i++) {
            stars[i] = "*".repeat(stars[i].length());
        }

        String sentence = getSentence(inoutFileName);
        StringBuilder separateWord = new StringBuilder();
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
        writeUpdatedSentence(inoutFileName, result.toString());
    }

    public static void main(String[] args) throws IOException {
        String[] obscene = {"synchronized", "Java", "bottle", "neck"};
        censorFile("D:\\Progwards\\src\\ru\\progwards\\java1\\lessons\\io2\\hw_lesson11_task3", obscene);
    }
}
