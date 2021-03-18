package ru.progwards.java1.lessons.bitsworld;

import static ru.progwards.java1.lessons.bitsworld.CheckBit.checkBit;

public class SumBits {
    /*

Задача 1. Класс SumBits
1.1 Реализовать функцию public static int sumBits(byte value), которая суммирует все биты параметра value.
Например, для двоичного числа 0100101 функция должна вернуть 3.

Подсказки:
используйте & с числом 1 для того, чтобы оставить только один правый значащий бит;
используйте сдвиг вправо для того, чтобы проверить следующий бит.

-128:   "10000000" - 1
1:      "00000001" - 1
127:    "01111111" - 7
0:      "00000000" - 0
-1:     "11111111" - 8

     */

    // мой вариант 1
    public static int sumBitsOnSubstring(byte value) {
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

    // мой вариант 2
    public static int mySumBits(byte value) {
        int result = 0;
        byte mask = (byte) 1;

        if (value == 0) {
            return 0;
        } else {
            for (int i = 0; i < 8; i++) {
                if ((value & mask) != 0) {
                    result++;
                }
                mask <<= 1;
            }
        }
        return result;
    }

    // по варианту С.А.
    public static int sumBits(byte value) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            byte byteValue = value;
            result += checkBit(byteValue, i);
        }
        return result;
    }

    static void myTest() {
        byte[] testArray = {-128, 1, 127, 0, -1};
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(sumBits(testArray[i]));
        }
    }

    public static void main(String[] args) {
        myTest();
    }
}
