package lesson7.part3;

import lesson7.part1.CalcDecToBin;

public class NumberSystem {

    static String val2Digit(int value) {
        /*
        switch (value) {
            case 10: return "A";
            case 11: return "B";
            case 12: return "C";
            case 13: return "D";
            case 14: return "E";
            case 15: return "F";
            default: return Integer.toString(value);
        }
         */
        return switch (value) {
            case 10 -> "A";
            case 11 -> "B";
            case 12 -> "C";
            case 13 -> "D";
            case 14 -> "E";
            case 15 -> "F";
            default -> Integer.toString(value);
        };
    }

    static String show(int value, int base) {
        String result = "";
        while (value > 0) {
            int reminder = value % base;
            result = val2Digit(reminder) + result;
            value /= base;
        }

        if (result.isEmpty()) {
            return "0";
        }
        return result;
    }

    static void myTest(int value) {
        System.out.println("Число: " + value + ", основание: " + 10 + ", результат: " + value);
        System.out.println("Число: " + value + ", основание: " + 2 + ", результат: " + show(value, 2));
        System.out.println("Число: " + value + ", основание: " + 16 + ", результат: " + show(value, 16));
        System.out.println();
    }

    public static void main(String[] args) {
        myTest(15);
        myTest(255);
    }
}
