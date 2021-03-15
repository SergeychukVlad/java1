package ru.progwards.java1.lessons.bitsworld;

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

    public static int checkBit(byte value, int bitNumber) {
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

    static void myTest(byte value, int bitNumber) {
        System.out.println("Исходное число: " + value);
        System.out.println("Запрашиваемый номер бита: " + bitNumber);
        System.out.println("Хранящееся значение: " + checkBit(value, bitNumber));
        System.out.println();
    }

    public static void main(String[] args) {
        byte[] testArray = {9, 8, -128, -1, 0};
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < 8; j++) {
                myTest(testArray[i], j);
            }
        }
    }
}
