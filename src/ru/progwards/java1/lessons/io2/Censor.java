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

    private static RandomAccessFile raf;
    private static final String myFileName = "D:\\Progwards\\src\\ru\\progwards\\java1\\lessons\\io2\\hw_lesson11_task3";

    public static synchronized RandomAccessFile getInstance(String fileName, String mode) throws CensorException {
        if (raf == null) {
            try {
                raf = new RandomAccessFile(new File(fileName), mode);
            } catch (FileNotFoundException notFoundException) {
                notFoundException.printStackTrace();
            }
        }
        return raf;
    }

    public static class CensorException extends Exception {
        private final String fileName;
        private final String errorCode;

        public CensorException() {
            this.fileName = myFileName;
            this.errorCode = "что-то идёт не так...";
        }

        @Override
        public String toString() {
            return fileName + ":" + errorCode;
        }
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
        try {
            raf = getInstance(inoutFileName, "rw");
        } catch (CensorException ce) {
            ce.printStackTrace();
        }
        try {
            sentence = raf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(sentence.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    private static String updateSentence(String sentence, String[] obscene) {
        // сделали массив-клон со звездочками вместо символов оригинального obscene[]
        String[] stars = obscene.clone();
        for (int i = 0; i < stars.length; i++) {
            stars[i] = "*".repeat(stars[i].length());
        }

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
                result.append(getStarsWord(obscene, stars, separateWord.toString()))
                        .append(getSymbol(charsOfSentence[i]));
                separateWord = new StringBuilder();
            }
        }

        return result.toString();
    }

    private static void writeUpdatedSentence(String inoutFileName, String updatedSentence) {
        try {
            raf = getInstance(inoutFileName, "rw");
        } catch (CensorException ce) {
            ce.getStackTrace();
        }
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

    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {
        if (inoutFileName == null || obscene == null) {
            throw new CensorException();
        } else writeUpdatedSentence(inoutFileName, updateSentence(getSentence(inoutFileName), obscene));

    }

    public static void main(String[] args) throws CensorException {
        String[] obscene = {"synchronized", "Java", "bottle", "neck"};
        censorFile(myFileName, obscene);
    }
}
