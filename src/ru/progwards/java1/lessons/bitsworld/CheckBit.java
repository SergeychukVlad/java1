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
