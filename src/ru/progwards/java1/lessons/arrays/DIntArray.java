package ru.progwards.java1.lessons.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DIntArray {
    private int[] intArray = {};

    public void add(int num) {
        int[] bufferArray = new int[intArray.length + 1];
        System.arraycopy(intArray, 0, bufferArray, 0, intArray.length);

        System.out.println("add()");
        System.out.println("Дано:      " + Arrays.toString(intArray));
        System.out.println("Добавляем элемент со значением " + num + " в конец массива");

        bufferArray[intArray.length] = num;
        intArray = bufferArray;
        System.out.println("Результат: " + Arrays.toString(intArray));
        System.out.println();
    }

    public void atInsert(int pos, int num) {
        int[] bufferArray = new int[intArray.length + 1];

        System.out.println("atInsert()");
        System.out.println("Дано:      " + Arrays.toString(intArray));
        System.out.println("Добавляем в позицию " + pos + " элемент со значением " + num);

        System.arraycopy(intArray, 0, bufferArray, 0, pos);
        for (int i = 0; i < pos; i++) {
            bufferArray[i] = intArray[i];
        }
        bufferArray[pos] = num;
        for (int i = pos; i < intArray.length; i++) {
            bufferArray[i + 1] = intArray[i];
        }

        intArray = bufferArray;
        System.out.println("Результат: " + Arrays.toString(intArray));
        System.out.println();
    }

    public void atDelete(int pos) {
        int[] bufferArray = new int[intArray.length - 1];

        System.out.println("atDelete()");
        System.out.println("Дано:      " + Arrays.toString(intArray));
        System.out.println("Удаляем элемент с индексом " + pos);

        for (int i = 0; i < pos; i++) {
            bufferArray[i] = intArray[i];
        }
        for (int i = pos; i < intArray.length - 1; i++) {
            bufferArray[i] = intArray[i + 1];
        }

        intArray = bufferArray;
        System.out.println("Результат: " + Arrays.toString(intArray));
        System.out.println();
    }

    public int at(int pos) {
        int result;
        System.out.println("at()");
        System.out.println("Дано:      " + Arrays.toString(intArray));
        System.out.println("Возвращаем элемент с индексом " + pos);
        System.out.println("На позиции " + pos + " находится элемент со значением " + intArray[pos]);
        result = intArray[pos];
        System.out.println();
        return result;
    }

    static void myTest() {
        DIntArray dIntArray = new DIntArray();
        dIntArray.add(105);
        dIntArray.add(-90);
        dIntArray.atInsert(1, 200);
        dIntArray.atInsert(2, -16);
        dIntArray.at(1);
        dIntArray.atDelete(0);
    }

    public static void main(String[] args) {
       myTest();
    }
}
