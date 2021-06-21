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
        this.inLang = inLang;
        this.outLang = outLang;
    }

    String translate(String sentence) {
        String endOfResultString;
        if (sentence.endsWith("!") || sentence.endsWith("?") || sentence.endsWith(".")) {
            endOfResultString = sentence.substring(sentence.length() - 1);
        } else {
            endOfResultString = "";
        }
        StringBuilder result = new StringBuilder();
        String regex = "\\s*(\\s|,|!|\\.)\\s*";
        String[] splittedSentence = sentence.split(regex);
        for (int i = 0; i < splittedSentence.length; i++) {
            for (int j = 0; j < inLang.length; j++) {
                if (splittedSentence[i].equalsIgnoreCase(inLang[i])) {
                    String wordForResultString = "";
                    if (splittedSentence[i].startsWith(splittedSentence[i].substring(0, 1).toUpperCase())) {
                        wordForResultString = outLang[i].substring(0, 1).toUpperCase() + outLang[i].substring(1);
                    } else {
                        wordForResultString = outLang[i];
                    }
                    result.append(wordForResultString).append(" ");

                    if (i >= splittedSentence.length) {
                    } else {
                        result.append(wordForResultString).append(endOfResultString);
                    }
                    break;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Translator engToRus = new Translator(
                new String[]{"hello", "world", "people", "like", "football", "champion", "watch"},
                new String[]{"привет", "мир", "люди", "любят", "футбол", "чемпионат", "смотреть"}
        );
        System.out.println(engToRus.translate("Hello World!"));
    }
}
