package ru.progwards.java1.lessons.bitsworld;

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

    public String toString() {
        String[] zeroStr = {"", "0", "00", "000", "0000", "00000", "000000", "0000000"};
        String numStr = Integer.toBinaryString(num);
        if (num < 0) {
            return numStr.substring(numStr.length() - 8);
        } else {
            return zeroStr[8 - numStr.length()].concat(numStr);
        }
    }

    static void myTest() {
        byte[] testArray = {0, 1, 127, -128, -1};
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(new Binary(testArray[i]).toString());
        }
    }

    public static void main(String[] args) {
        myTest();
    }
}
