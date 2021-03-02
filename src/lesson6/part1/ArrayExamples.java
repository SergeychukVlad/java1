package lesson6.part1;

import java.lang.reflect.Array;

public class ArrayExamples {
    static void myTest1() {
        int[] ints = new int[]{1, 4, 5, 6, 8};
        int[] intArray = new int[]{21, 34, 55, 89, 144};
        String[] strings1 = new String[5];
        String[] strings2 = new String[]{"мне", "всё", "понятно"};

        System.out.println("ints[0] = " + ints[0]);
        System.out.println("strings2[0] = " + strings2[0]);
        System.out.println("strings2[2] = " + strings2[2]);
        System.out.println(strings1[4] != null);
        System.out.println(ints[4] > ints[0]);
        System.out.println("ints.length = " + ints.length);
        System.out.println("strings2.length = " + strings2.length);

        printArray(ints);
        printArray(strings1);
        System.out.println("CheckFibo1 = " + checkFibo(ints));
        System.out.println("CheckFibo2 = " + checkFibo(intArray));
        printArray(intArray);
        printArray(reverse(intArray));
        checkFiboRule1();
        checkFiboRule2();
    }

    static void printArray(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Элемент № " + i + " = " + intArray[i]);
        }
    }

    static void printArray(String[] stringArray) {
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("Элемент № " + i + " = " + stringArray[i]);
        }
    }

    static boolean checkFibo(int[] intArray) {
        for (int i = 2; i < intArray.length; i++) {
            if (intArray[i - 2] + intArray[i - 1] != intArray[i]) {
                return false;
            }
        }
        return true;
    }

    static int[] reverse(int[] originalArray) {
        int[] reversedArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[originalArray.length - 1 - i] = originalArray[i];
        }
        return reversedArray;
    }

    // обычный трёхмерный массив
    static void checkFiboRule1() {
        int[] simpleArray1 = {21, 34, 55, 89, 144};
        int[] simpleArray2 = {144, 89, 55, 34, 21};
        int[] simpleArray3 = new int[5];
        int[][] intArray2D = {simpleArray1, simpleArray2, simpleArray3};
        System.out.println("intArray2D length = " + intArray2D.length);
        for (int i = 0; i < intArray2D.length; i++) {
            System.out.println("checkFibo " + i + " = " + checkFibo(intArray2D[i]));
        }
    }

    // ступенчатый массив
    static void checkFiboRule2() {
        int[] simpleArray1 = {21, 34, 55, 89, 144};
        int[] simpleArray2 = {144, 89, 55};
        int[] simpleArray3 = new int[4];
        int[][] intArray2D = {simpleArray1, simpleArray2, simpleArray3};
        System.out.println("intArray2D length = " + intArray2D.length);

        for (int i = 0; i < intArray2D.length; i++) {
            System.out.println("Длина массива " + i + " = " + intArray2D[i].length);
            System.out.println("checkFibo " + i + " = " + checkFibo(intArray2D[i]));
        }
    }

    public static void main(String[] args) {
        myTest1();
    }
}
