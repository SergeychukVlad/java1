package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a) {
        int maxValue;
        System.out.println("Дано:      " + Arrays.toString(a));
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] > a[i]) {
                    maxValue = a[j];
                    a[j] = a[i];
                    a[i] = maxValue;
                }
            }
        }
        System.out.println("Результат: " + Arrays.toString(a));
    }

    static void myTest() {
        int[] intArray = {-17, -2205, 200, 0, 310, 1055, 90, 80, 0};
        sort(intArray);
        intArray[4] = -900;
        intArray[5] = 15;
        sort(intArray);
    }

    public static void main(String[] args) {
        myTest();
    }
}
