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

    public static String getTranslatedWord(String inWord, boolean wordInUpperCase) {
        StringBuilder outWord = new StringBuilder();
        for (int j = 0; j < inLang.length; j++) {
            if (inWord.equalsIgnoreCase(inLang[j])) {
                if (wordInUpperCase)
                    outWord.append(outLang[j].substring(0, 1).toUpperCase()).append(outLang[j].substring(1));
                else outWord.append(outLang[j]);
                break;
            }
        }
        return outWord.toString();
    }

    String translate(String sentence) {
        StringBuilder inWord = new StringBuilder();
        StringBuilder outSentence = new StringBuilder();
        char[] charsOfSentence = sentence.toCharArray();
        boolean wordInUpperCase = false;

        for (int i = 0; i < charsOfSentence.length; i++) {
            char ch = charsOfSentence[i];
            if (Character.isLetter(ch)) {
                inWord.append(ch);
                if (Character.isUpperCase(ch)) wordInUpperCase = true;
            } else {
                outSentence.append(getTranslatedWord(inWord.toString(), wordInUpperCase));
                outSentence.append(getSymbol(ch));
                inWord = new StringBuilder();
                wordInUpperCase = false;
            }
            // если строка не заканчивается знаком препинания или \r, то "ловим" слово на конце строки таким образом:
            if (i == charsOfSentence.length - 1)
                outSentence.append(getTranslatedWord(inWord.toString(), wordInUpperCase));
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
