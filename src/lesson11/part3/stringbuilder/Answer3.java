package lesson11.part3.stringbuilder;

public class Answer3 {
    static String invertWords(String sentence) {
        String[] sentenceArr = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = sentenceArr.length - 1; i >= 0; i--) {
            if (i == 0) {
                stringBuilder.append(sentenceArr[i]);
            } else
                stringBuilder.append(sentenceArr[i] + ".");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(invertWords("Буря мглою небо кроет"));
    }
}
