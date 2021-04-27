package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    public int rangeOfArray;
    public byte[] digits;

    public ArrayInteger(int n) {
        this.rangeOfArray = n;
        digits = new byte[n];
        Arrays.fill(digits, (byte) 0);
    }

    public static void main(String[] args) {
        ArrayInteger arrayInteger1 = new ArrayInteger(7);
        arrayInteger1.fromInt(new BigInteger("8028124"));
        System.out.println("arrayInteger1: " + Arrays.toString(arrayInteger1.digits));
        arrayInteger1.toInt();

        ArrayInteger arrayInteger2 = new ArrayInteger(5);
        arrayInteger2.fromInt(new BigInteger("79896"));
        System.out.println("arrayInteger2: " + Arrays.toString(arrayInteger2.digits));
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
/*  вариант enhanced switch от Idea
            switch (bytes[i]) {
                case 48 -> digits[i] = 0;
                case 49 -> digits[i] = 1;
                case 50 -> digits[i] = 2;
                case 51 -> digits[i] = 3;
                case 52 -> digits[i] = 4;
                case 53 -> digits[i] = 5;
                case 54 -> digits[i] = 6;
                case 55 -> digits[i] = 7;
                case 56 -> digits[i] = 8;
                case 57 -> digits[i] = 9;
            }
 */

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
/*
            for (int j = this.rangeOfArray - 1; j >= shift; j--) {
                cloneNumArray[j] = num.digits[j - shift];
            }

 */
            if (this.rangeOfArray - shift >= 0)
                System.arraycopy(num.digits, 0, cloneNumArray, shift, this.rangeOfArray - shift);
            System.out.println("cloneNumArray: " + Arrays.toString(cloneNumArray));
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
            System.out.println("После add(): " + Arrays.toString(this.digits));
            return false;
        } else {
            System.out.println("После add()  : " + Arrays.toString(this.digits));
            return true;
        }
    }
}
