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

    // по варианту С.А.
    public String toString() {
        String resultString = "";
        for (int i = 7; i >= 0; i--) {
            resultString += checkBit(num, i);
        }
        return resultString;
    }

    static void myTest() {
        byte[] testArray = {-128, 1, 127, 0, -1};
        for (byte b : testArray) {
            System.out.println("число " + b + ": " + new Binary(b).toString());
        }
    }

    public static void main(String[] args) {
        myTest();
    }
}
