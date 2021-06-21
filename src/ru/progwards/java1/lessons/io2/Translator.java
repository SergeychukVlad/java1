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
        StringBuilder result = new StringBuilder();
        // запятая и восклицательный знак не будут разделителями, чтобы "отловить" их место во фразе
        String regex = "\\s*(\\s|\\?|\\.)\\s*";
        String[] splittedSentence = sentence.split(regex);

        for (int i = 0; i < splittedSentence.length; i++) {
            String wordForResultString = "";
            for (int j = 0; j < inLang.length; j++) {

                // сразу проверяем и на совпадение слова с запятой, с восклицательным знаком
                if (splittedSentence[i].trim().equalsIgnoreCase(inLang[j])
                        || splittedSentence[i].trim().equalsIgnoreCase(inLang[j] + ",")
                        || splittedSentence[i].trim().equalsIgnoreCase(inLang[j] + "!")) {
                    if (splittedSentence[i].startsWith(splittedSentence[i].substring(0, 1).toUpperCase()))
                        wordForResultString = outLang[j].substring(0, 1).toUpperCase() + outLang[j].substring(1);
                    else
                        wordForResultString = outLang[j];

                    // сохраняем запятую на месте в переводе
                    if (splittedSentence[i].endsWith(","))
                        wordForResultString = wordForResultString + ",";

                    // сохраняем восклицательный знак на месте в переводе
                    if (splittedSentence[i].endsWith("!"))
                        wordForResultString = wordForResultString + "!";

                    // формируем строку перевода с сохранением пунктуации
                    if (i == (splittedSentence.length - 1))
                        result.append(wordForResultString);
                    else
                        result.append(wordForResultString).append(" ");
                    break;
                }
            }
            // на случай, если нет соответствия в словаре
            if (wordForResultString.equals("")) {
                return "В словаре нет совпадений для слова " + splittedSentence[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] english = {"hello", "world", "people", "like", "football", "champion", "spartak", "watch"};
        String[] russian = {"привет", "мир", "люди", "любят", "футбол", "чемпион", "cпартак", "смотреть"};

        Translator engToRus = new Translator(english, russian);
        System.out.println(engToRus.translate("people like world! Football, Spartak!"));
        System.out.println(engToRus.translate("Spartak champion!"));

        Translator rusToEng = new Translator(russian, english);
        System.out.println(rusToEng.translate("люди любят Мир"));
        System.out.println(rusToEng.translate("привет Футбол!"));
    }
}
