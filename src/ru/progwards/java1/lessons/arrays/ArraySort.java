package ru.progwards.java1.lessons.arrays;

public class ArraySort {

    public static void sort(int[] a) {
        int buffer;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    buffer = a[i];
                    a[i] = a[j];
                    a[j] = buffer;
                }
            }
        }
    }

    static void myTest() {
        int[] intArray = {-17, -2205, 200, 0, 310, 1055, 90, 80, 0};
        intArray[4] = -900;
        intArray[5] = 15;
        sort(intArray);
        intArray[0] = 100;
        intArray[7] = -500;
        sort(intArray);
    }

    public static void main(String[] args) {
        myTest();
    }
}
