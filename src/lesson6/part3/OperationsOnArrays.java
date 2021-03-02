package lesson6.part3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class OperationsOnArrays {
    static void arraysToString() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        byte[] arrayByte = {1, 2, 3, 4, 5};
        double[] arrayDouble = {-9E5, 0, -123.34533, Math.PI, 55.555};
        String[] arrayString = {"Arrays.toString()", "удобно", "выводить", "массив", "на консоль"};

        System.out.println(Arrays.toString(arrayByte));
        System.out.println(Arrays.toString(arrayDouble));
        System.out.println(Arrays.toString(arrayString));
    }

    static void arraysEquals() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        int[] arrayInt1 = {1, 2, 3, 4, 5};
        int[] arrayInt2 = {5, 4, 3, 2, 1};
        int[] arrayInt3 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.equals(arrayInt1, arrayInt2));
        System.out.println(Arrays.equals(arrayInt1, arrayInt3));
    }

    static void arraysDeepEquals() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        int[] arrayInt1 = {1, 2, 3, 4, 5};
        int[] arrayInt2 = {5, 4, 3, 2, 1};
        int[] arrayInt3 = {1, 2, 3, 4, 5};
        int[][] arrayInt2D_1 = {arrayInt1, arrayInt2, arrayInt3};
        int[][] arrayInt2D_2 = {arrayInt1, arrayInt2, arrayInt1};

        System.out.println(Arrays.toString(arrayInt2D_1));
        System.out.println(Arrays.toString(arrayInt2D_2));
        System.out.println(Arrays.equals(arrayInt2D_1, arrayInt2D_2));

        System.out.println(Arrays.deepToString(arrayInt2D_1));
        System.out.println(Arrays.deepToString(arrayInt2D_2));
        System.out.println(Arrays.deepEquals(arrayInt2D_1, arrayInt2D_2));
    }

    static void arrayFill() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        int[] intArray = new int[5];
        System.out.println(Arrays.toString(intArray));

        Arrays.fill(intArray, -2);
        System.out.println(Arrays.toString(intArray));
    }

    static void arrayCopy1() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        int[] arrayInt = {3, 5, 7, 9};
        int[] arrayIntCopy = arrayInt;
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));

        arrayInt[0] = 456;
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));
    }

    static void arrayCopyOf() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        int[] arrayInt = {3, 5, 7, 9};
        int[] arrayIntCopy = Arrays.copyOf(arrayInt, arrayInt.length);
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));

        arrayInt[0] = 456;
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));
    }

    static void arrayCopyOfObjects() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        Integer[] arrayInt = {3, 5, 7, 9};
        Integer[] arrayIntCopy = Arrays.copyOf(arrayInt, arrayInt.length);
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));

        arrayInt[0] = 456;
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));
    }

    static void arrayCopyOfObjectsAtomicInteger() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        AtomicInteger[] arrayInt = {
                new AtomicInteger(3),
                new AtomicInteger(5),
                new AtomicInteger(7),
                new AtomicInteger(9)
        };

        AtomicInteger[] arrayIntCopy = Arrays.copyOf(arrayInt, arrayInt.length);
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));

        arrayInt[0].set(456);
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));
    }

    static void systemArrayCopy() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        int[] arrayInt = {3, 5, 7, 9};
        int[] arrayIntCopy = new int[arrayInt.length];
        System.arraycopy(arrayInt, 0, arrayIntCopy, 0, arrayIntCopy.length);

        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));

        arrayInt[0] = 456;
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(arrayIntCopy));
    }

    static void arraySort() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        int[] arrayInt = {3, 5, 7, 9, -4, 0, 20};
        System.out.println("До сортировки: " + Arrays.toString(arrayInt));
        Arrays.sort(arrayInt);
        System.out.println("После сортировки: " + Arrays.toString(arrayInt));
    }

    static void arrayBinarySearch() {
        System.out.println("--- " + new Throwable().getStackTrace()[0].getMethodName() + " ---");
        int[] arrayInt = {3, 5, 7, 9, -4, 0, 20};
        int key = arrayInt[4];

        System.out.println("До сортировки: " + Arrays.toString(arrayInt));
        System.out.println("Номер элемента со значением " + key + " : " + Arrays.binarySearch(arrayInt, key));

        Arrays.sort(arrayInt);
        System.out.println("После сортировки: " + Arrays.toString(arrayInt));
        System.out.println("Номер элемента со значением " + key + " : " + Arrays.binarySearch(arrayInt, key));
    }

    public static void main(String[] args) {
        arraysToString();
        arraysEquals();
        arraysDeepEquals();
        arrayFill();
        arrayCopy1();
        arrayCopyOf();
        arrayCopyOfObjects();
        arrayCopyOfObjectsAtomicInteger();
        systemArrayCopy(); // имеет самое лучшее быстродействие!
        arraySort();
        arrayBinarySearch(); // поиск элемента по значению. РАБОТАЕТ ДОСТОВЕРНО ТОЛЬКО В ОТСОРТИРОВАННОМ МАССИВЕ!
    }
}