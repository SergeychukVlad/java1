package lesson11.part2;

import java.util.Scanner;

/*
Scanner. чтение строк и чисел.
 */
public class ScannerString {

    public static void readString(String str) {
        try (Scanner scanner = new Scanner(str)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                System.out.println("Слово: " + word);
            }
        }
        System.out.println();
    }

    public static void readStringAndNumber(String str) {
        try (Scanner scanner = new Scanner(str)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    System.out.println("Число: " + num);
                } else {
                    String word = scanner.next();
                    System.out.println("Слово: " + word);
                }
            }
        }
        System.out.println();
    }

    public static void readNumberStringWithDelimiter(String str) {
        /*
        Для Scanner разделитель по умолчанию - ПРОБЕЛ.
        useDelimiter позволяет изменить разделитель
         */
        try (Scanner scanner = new Scanner(str).useDelimiter("\\s*,\\s*")) {
            /*
            Внимание! В аргументе useDelimiter ПРОБЕЛОВ В МАСКЕ БЫТЬ НЕ ДОЛЖНО!
            useDelimiter("\\s*, \\s*") - не работает!
            useDelimiter("\\s*,\\s*") - работает!
             */
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.println("Число: " + num);
            }
        }
    }

    public static void main(String[] args) {
        String str = "Эта строка состоит из 5 слов";
        System.out.println(" === readString() === ");
        readString(str);

        System.out.println(" === readStringAndNumber() === ");
        readStringAndNumber(str);

        System.out.println(" === readNumberStringWithDelimiter() === ");
        str = "1,2,3    ,4   ,5,6   , 7, 8, 9,     10   ,";
        readNumberStringWithDelimiter(str);
    }
}
