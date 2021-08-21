package ru.progwards.java1.lessons.collections;

public class IteratorTest {
    public static void main(String[] args) {
        Integer[] forArrayIterator = new Integer[]{1, 3, 67, 89, 222};
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(forArrayIterator);
        withArrayIterator(arrayIterator);

        System.out.println();

        Integer[][] integersArray = new Integer[][]{
                {1, 2, 3},
                {40, 50, 60},
                {700, 800, 900},
                {1000, 1001, 1002}};
        MatrixIterator<Integer> integerMatrixIterator = new MatrixIterator<>(integersArray);
        withMatrixIteratorInteger(integerMatrixIterator);

        System.out.println();

        String[][] stringArray = new String[][]{
                {"Иван", "Марья", "Алекс"},
                {"Сто", "Двести", "Триста"},
                {"Семь", "Восемь", "Три"},
                {"Это", "будет", "работать"}};
        MatrixIterator<String> stringMatrixIterator = new MatrixIterator<>(stringArray);
        withMatrixIteratorString(stringMatrixIterator);
    }

    public static void withArrayIterator(ArrayIterator<Integer> arrayIterator) {
        while (arrayIterator.hasNext()) {
            System.out.print(arrayIterator.next() + " ");
        }
    }

    public static void withMatrixIteratorInteger(MatrixIterator<Integer> matrixIterator) {
        while (matrixIterator.hasNext()) {
            System.out.print(matrixIterator.next() + " ");
        }
    }

    public static void withMatrixIteratorString(MatrixIterator<String> matrixIterator) {
        while (matrixIterator.hasNext()) {
            System.out.print(matrixIterator.next() + " ");
        }
    }
}
