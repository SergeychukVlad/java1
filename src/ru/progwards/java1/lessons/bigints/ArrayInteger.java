/*
Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;

Реализовать методы:
3.1 ArrayInteger(int n) - инициализирует класс, с максимальной точностью n цифр (размер массива)
3.2 void fromInt(BigInteger value) - установить свое значение,
взяв его из value (уложить BigInteger во внутренний массив)
3.3 BigInteger toInt() - привести свое значение к BigInteger (преобразовать из массива в BigInteger)
3.4 boolean add(ArrayInteger num) - сложить 2 числа, не используя BigInteger,
а  используя массив digits, результат поместить в экземпляр ArrayInteger, у которого был вызван метод.
При переполнении вернуть false, при этом само число сбросить в 0
 */
package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    private int rangeOfArray;
    private byte[] digits;

    public ArrayInteger(int n) {
        this.rangeOfArray = n;
        digits = new byte[n];
        Arrays.fill(digits, (byte) 0);
    }

    public static void main(String[] args) {
        ArrayInteger arrayInteger1 = new ArrayInteger(7);
        arrayInteger1.fromInt(new BigInteger("8028124"));
        arrayInteger1.toInt();

        ArrayInteger arrayInteger2 = new ArrayInteger(5);
        arrayInteger2.fromInt(new BigInteger("79896"));
        arrayInteger1.add(arrayInteger2);
    }

    void fromInt(BigInteger value) {
        byte[] bytes = value.toString().getBytes();
        for (int i = 0; i < rangeOfArray; i++) {
            digits[i] = bytes[i];
            switch (bytes[i]) {
                case 48:
                    digits[i] = 0;
                    break;
                case 49:
                    digits[i] = 1;
                    break;
                case 50:
                    digits[i] = 2;
                    break;
                case 51:
                    digits[i] = 3;
                    break;
                case 52:
                    digits[i] = 4;
                    break;
                case 53:
                    digits[i] = 5;
                    break;
                case 54:
                    digits[i] = 6;
                    break;
                case 55:
                    digits[i] = 7;
                    break;
                case 56:
                    digits[i] = 8;
                    break;
                case 57:
                    digits[i] = 9;
                    break;
            }
        }
    }

    BigInteger toInt() {
        StringBuilder convertedString = new StringBuilder();
        for (byte s : digits) {
            convertedString.append(String.valueOf(s));
        }
        return new BigInteger(convertedString.toString());
    }

    boolean add(ArrayInteger num) {
        byte currentItemValue;
        byte overflow = 0;
        byte[] cloneNumArray = this.digits.clone();

        if (this.rangeOfArray > num.rangeOfArray) {
            Arrays.fill(cloneNumArray, (byte) 0);
            int shift = this.rangeOfArray - num.rangeOfArray;
            if (this.rangeOfArray - shift >= 0)
                System.arraycopy(num.digits, 0, cloneNumArray, shift, this.rangeOfArray - shift);
        }

        for (int i = this.rangeOfArray - 1; i >= 0; i--) {
            if (this.rangeOfArray == num.rangeOfArray) {
                currentItemValue = (byte) (this.digits[i] + num.digits[i] + overflow);
            } else currentItemValue = (byte) (this.digits[i] + cloneNumArray[i] + overflow);
            if (currentItemValue > 9) {
                currentItemValue = (byte) (currentItemValue - 10);
                overflow = 1;
            } else overflow = 0;
            this.digits[i] = currentItemValue;
        }

        if (overflow == 1 || this.rangeOfArray < num.rangeOfArray) {
            Arrays.fill(this.digits, (byte) 0);
            return false;
        } else {
            return true;
        }
    }
}
