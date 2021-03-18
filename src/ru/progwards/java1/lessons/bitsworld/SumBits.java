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

    // по варианту С.А.
    public static int sumBits(byte value) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            result += checkBit(value, i);
        }
        return result;
    }

    static void myTest() {
        byte[] testArray = {-128, 1, 127, 0, -1};
        for (byte b : testArray) {
            System.out.println(sumBits(b));
        }
    }

    public static void main(String[] args) {
        myTest();
    }
}
