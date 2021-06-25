/*
Создать класс Translator - переводчик, который будет переводить предложения с одного языка на другой

2.1 Конструктор Translator(String[] inLang, String[] outLang), где inLang и outLang - массивы слов на разных языках,
например русском и английском. Сохранить значения параметров в приватных свойствах класса
2.2  Метод public String translate(String sentence), в котором найти слова, содержащиеся в sentence и в inLang
и заменить их на соответствующие в outLang. Пунктуация должна быть соблюдена (скопирована из оригинальной строки).
При этом надо соблюсти заглавные буквы, если они были в оригинальном тексте.
В inLang и outLang все слова хранятся в нижнем регистре.

Например, фраза
"Hello World!" будет переведена как "Привет Мир!"
при наличии слов "hello", "world" в inLang и "привет", "мир" в outLang
 */
package ru.progwards.java1.lessons.io2;

public class Translator {
    private static String[] inLang;
    private static String[] outLang;

    public Translator(String[] inLang, String[] outLang) {
        Translator.inLang = inLang;
        Translator.outLang = outLang;
    }

    public static char getSymbol(char symbol) {
        char[] punctuationSymbols = {' ', ',', '-', ':', '.', '!', '?', '\r', '\n'};
        for (char punctuationSymbol : punctuationSymbols) {
            if (symbol == punctuationSymbol) break;
        }
        return symbol;
    }

    public static String getTranslatedWord(String inWord, boolean isCapital) {
        StringBuilder outWord = new StringBuilder();
        boolean wordExist = false;

        for (int j = 0; j < inLang.length; j++) {
            if (inWord.equalsIgnoreCase(inLang[j])) {
                if (isCapital) outWord.append(outLang[j].substring(0, 1).toUpperCase()).append(outLang[j].substring(1));
                else outWord.append(outLang[j]);
                wordExist = true;
                break;
            }
        }
        if (wordExist) return outWord.toString();
        else return "*** " + inWord + " ***";
    }

    String translate(String sentence) {
        char[] charsOfSentence = sentence.toCharArray();
        StringBuilder inWord = new StringBuilder();
        StringBuilder outSentence = new StringBuilder();
        boolean isCapital = false;
        String translatedWord, symbol;

        for (int i = 0; i < charsOfSentence.length; i++) {
            if (Character.isLetter(charsOfSentence[i])) {
                inWord.append(charsOfSentence[i]);
                if (Character.isUpperCase(charsOfSentence[i])) {
                    isCapital = true;
                }
                // если строка не заканчивается знаком препинания (или \r), то "ловим" слово на индексе окончания строки
                if (i == charsOfSentence.length - 1) {
                    outSentence.append(getTranslatedWord(inWord.toString(), isCapital));
                }
            } else {
                symbol = String.valueOf(getSymbol(charsOfSentence[i]));
                if (!inWord.toString().isBlank())
                    translatedWord = getTranslatedWord(inWord.toString(), isCapital);
                else translatedWord = "";
                inWord = new StringBuilder();
                isCapital = false;
                outSentence.append(translatedWord)
                        .append((symbol));
            }
        }
        return outSentence.toString();
    }

    public static void main(String[] args) {
        String[] english = {"hello", "world", "people", "like", "football", "champion", "spartak", "watch"};
        String[] russian = {"привет", "мир", "люди", "любят", "футбол", "чемпион", "cпартак", "смотреть"};

        Translator engToRus = new Translator(english, russian);
        System.out.println(engToRus.translate("people like world - Football, Spartak!") + "\n");
        System.out.println(engToRus.translate("Spartak champion!") + "\n");

        Translator rusToEng = new Translator(russian, english);
        System.out.println(rusToEng.translate("люди любят Мир") + "\n");
        System.out.println(rusToEng.translate("приветe, Футбол!") + "\n");
        System.out.println(rusToEng.translate("привет, Футбол!") + "\n");
    }
}
