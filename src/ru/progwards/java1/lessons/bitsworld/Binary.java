package ru.progwards.java1.lessons.bitsworld;

import static ru.progwards.java1.lessons.bitsworld.CheckBit.checkBit;

public class Binary {
    /*

Задача 3. Класс Binary
3.1 Реализовать конструктор public Binary(byte num).
3.2 Реализовать метод public String toString(), который возвращает двоичное представление числа типа byte,
используя только битовые операции. В выводимом значении всегда должно быть 8 символов
Например:
0:      "00000000"
1:      "00000001"
127:    "01111111"
-128:   "10000000"
-1:     "11111111"

     */

    private byte num;

    public Binary(byte num) {
        this.num = num;
    }

    //    мой вариант 1
    public String toStringOnSubstring() {
        String[] zeroStr = {"", "0", "00", "000", "0000", "00000", "000000", "0000000"};
        String numStr = Integer.toBinaryString(num);
        if (num < 0) {
            return numStr.substring(numStr.length() - 8);
        } else {
            return zeroStr[8 - numStr.length()].concat(numStr);
        }
    }

    // мой вариант 2
    public String myToString() {
        String[] zeroStr = {"", "0", "00", "000", "0000", "00000", "000000", "0000000"};
        if (num < 0) {
            return Integer.toString(0b0000_0000_0000_0000_1111_1111 & num, 2);
        } else {
            String binaryString = Integer.toString((byte) 0b0 | num, 2);
            return zeroStr[8 - binaryString.length()] + binaryString;
        }
    }

    // по варианту С.А.
    public String toString() {
        String resultString = "";
        for (int i = 0; i < 8; i++) {
            int value = num;
            resultString = checkBit((byte) value, i) + resultString;
        }
        return resultString;
    }

    static void myTest() {
        System.out.println("число 0: " + new Binary((byte) 0).toString());
        System.out.println("число 1: " + new Binary((byte) 1).toString());
        System.out.println("число 8: " + new Binary((byte) 8).toString());
        System.out.println("число 127: " + new Binary((byte) 127).toString());
        System.out.println("число -128: " + new Binary((byte) -128).toString());
        System.out.println("число -1: " + new Binary((byte) -1).toString());
    }

    public static void main(String[] args) {
        myTest();
    }
}
