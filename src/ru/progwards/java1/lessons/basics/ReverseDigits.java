package ru.progwards.java1.lessons.basics;

import java.util.Arrays;
import java.util.List;

public class ReverseDigits {
    public static void main(String[] args) {
        List<Integer> digits = Arrays.asList(123, 456, 789, 501, 195);
        long startTime;

        for (Integer digit : digits) {
            startTime = System.nanoTime();
            reverseDigitsOnSubstring(digit);
            System.out.println("Время работы reverseDigitsOnSubstring: " + (System.nanoTime() - startTime) + " nSec.");
            System.out.println();

            startTime = System.nanoTime();
            reverseDigits(digit);
            System.out.println("Время работы reverseDigits: " + (System.nanoTime() - startTime) + " nSec.");
            System.out.println("------------------------------------------");
        }
    }

    public static int reverseDigitsOnSubstring(int number) {
        System.out.println("Метод reverseDigitsOnSubstring принимает число: " + number);
        String str = Integer.toString(number);
        String result = str.substring(2) + str.charAt(1) + str.charAt(0);
        System.out.println("Возвращает : " + result);
        return Integer.parseInt(result);
    }

    public static int reverseDigits(int number) {
        System.out.println("Метод reverseDigits принимает число: " + number);
        int firstDigit = number % 10;
        int middleDigit = (number / 10) % 10;
        int lastDigit = number / 100;
        String str = firstDigit + "" + middleDigit + "" + lastDigit;
        System.out.println("Возвращает: " + str);
        return Integer.parseInt(str);
    }
}
