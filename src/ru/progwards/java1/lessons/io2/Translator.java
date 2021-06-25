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

    public static char getSymbol(char symbol) {
        char[] punctuationSymbols = {' ', ',', '-', ':', '.', '!', '?', '\r', '\n'};
        for (char punctuationSymbol : punctuationSymbols) {
            if (symbol == punctuationSymbol) {
                break;
            }
        }
        return symbol;
    }

    String translate(String sentence) {
        StringBuilder inWord = new StringBuilder();
        StringBuilder outSentence = new StringBuilder();
        char[] charsOfSentence = sentence.toCharArray();
        boolean wordInUpperCase = false;
        boolean wordAppended = false;

        for (char ch : charsOfSentence) {
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) wordInUpperCase = true;
                inWord.append(ch);
            } else {
                for (int j = 0; j < inLang.length; j++) {
                    if (inWord.toString().equalsIgnoreCase(inLang[j])) {
                        if (wordInUpperCase)
                            outSentence.append(outLang[j].substring(0, 1).toUpperCase()).append(outLang[j].substring(1));
                        else outSentence.append(outLang[j]);

                        wordAppended = true;
                        inWord = new StringBuilder();
                        wordInUpperCase = false;
                        break;
                    }
                }
                // если нет совпадений в словаре
                if (!wordAppended) return "В словаре нет перевода для этого слова - " + inWord.toString().toUpperCase();
                else outSentence.append(getSymbol(ch));
            }
        }
        // если строка не имеет знака препинания в конце и нет знака \r, то "ловим" слово таким образом:
        if (inWord.isEmpty()) return outSentence.toString();
        else return outSentence.append(inWord).toString();
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
    }
}
