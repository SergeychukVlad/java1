package lesson7.homework;

public class CheckBit {
    /*

Задача 2. Класс CheckBit
2.1 Реализовать функцию public static int checkBit(byte value, int bitNumber)
которая возвращает значение бита с порядковым номером bitNumber от параметра value.
При этом следует помнить, что нумерация начинается с нуля и нулевой бит является младшим.

Подсказки:
при реализации этой функции следует использывать опыт, полученный при решении предыдущей задачи;
кроме того, удобно использовать битовую операцию сдвиг вправо >>.

     */

    // мой вариант 1
    public static int checkBitOnSubstring(byte value, int bitNumber) {
        if (bitNumber > 8) {
            // что-то надо вернуть... Вот это значение и возвращаю.
            System.out.println("Бит № " + bitNumber + " не определён для числа типа byte!");
            return bitNumber;
        }

        String binaryString = Integer.toBinaryString(value);
        if (value < 0) { // для отрицательного value. Обрезать до 8-ми знаков.
            binaryString = binaryString.substring(binaryString.length() - 8);
        } else {         // для положительного value. Дополнить нулями до 8-ми знаков
            binaryString = "0".repeat(8 - binaryString.length()).concat(binaryString);
        }
        return Integer.parseInt(binaryString.substring(8 - bitNumber - 1, 8 - bitNumber));
    }

    // мой вариант 2
    public static int myCheckBit(byte value, int bitNumber) {
        byte mask = (byte) 1;
        mask <<= bitNumber;
        if ((value & mask) != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // вариант по варианту С.А.
    public static int checkBit(byte value, int bitNumber) {
        value >>= bitNumber;
        return value & 0b1;
    }

    static void myTest() {
        byte[] testArray = {9, -87, 8, -128, -1, 0};
        for (byte b : testArray) {
            System.out.println("Исходное число: " + b + " (" + Integer.toBinaryString(b) + ")");
            for (int bit = 0; bit < 8; bit++) {
                System.out.print("Запрашиваемый номер бита: " + bit + ". ");
                System.out.println("Хранящееся значение: " + checkBit(b, bit));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        myTest();
    }
}
