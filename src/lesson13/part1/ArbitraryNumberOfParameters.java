/*
Произвольное число параметров
*/
package lesson13.part1;

public class ArbitraryNumberOfParameters {
    public static void threeDots(String... strings) {
        System.out.println("\n Передано параметров: " + strings.length);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        threeDots();
        threeDots("Три точки после типа,",
                "В том месте, где параметры,",
                "Нам говорит, что их число,",
                "Неведомо заранее.");

        String[] arrayOfString = {"+", "Можно передать", "массив"};
        threeDots(arrayOfString);
    }
}
