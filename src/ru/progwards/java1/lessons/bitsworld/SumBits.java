package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    /*

Задача 1. Класс SumBits
1.1 Реализовать функцию public static int sumBits(byte value), которая суммирует все биты параметра value.
Например, для двоичного числа 0100101 функция должна вернуть 3.

Подсказки:
используйте & с числом 1 для того, чтобы оставить только один правый значащий бит;
используйте сдвиг вправо для того, чтобы проверить следующий бит.

     */

    public static int sumBits(byte value) {
        String binaryString = Integer.toBinaryString(value);
        int result = 0;
        if (value < 0) { // для отрицательного value. Обрезать до 8-ми знаков.
            binaryString = binaryString.substring(binaryString.length() - 8);
            for (int i = 0; i < binaryString.length(); i++) {
                result += Integer.parseInt(binaryString.substring(i, i + 1));
            }
        } else {
            for (int i = 0; i < binaryString.length(); i++) {
                result += Integer.parseInt(binaryString.substring(i, i + 1));
            }
        }
        System.out.println(binaryString);
        return result;
    }

    static void myTest() {
        byte[] testArray = {0, 1, 127, -128, -1};
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(sumBits(testArray[i]));
        }
    }

    public static void main(String[] args) {
        myTest();
    }
}
