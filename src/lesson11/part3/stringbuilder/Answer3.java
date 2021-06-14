package lesson11.part3.stringbuilder;

import java.util.Arrays;

public class Answer3 {
    static String invertWords1(String sentence) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] sentenceArr = sentence.split(" ");
        for (int i = sentenceArr.length - 1; i >= 0; i--) {
            if (i == 0) {
                stringBuilder.append(sentenceArr[i]);
            } else
                stringBuilder.append(sentenceArr[i] + ".");
        }
        return stringBuilder.toString();
    }

    static String invertWords2(String sentence) {
        String reverseSentence = "";
        String[] sentenceArr = sentence.split(" ");
        for (int i = 0; i < sentenceArr.length; i++) {
            if (i == sentenceArr.length - 1) {
                reverseSentence += sentenceArr[(sentenceArr.length - 1) - i];
            } else
                reverseSentence += sentenceArr[(sentenceArr.length - 1) - i] + ".";
        }
        return reverseSentence;
    }

    public static void main(String[] args) {
        System.out.println(invertWords1("Буря мглою небо кроет"));
        System.out.println(invertWords2("Буря мглою небо кроет"));
    }
}
