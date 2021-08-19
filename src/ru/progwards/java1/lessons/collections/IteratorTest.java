package ru.progwards.java1.lessons.collections;

public class IteratorTest {
    public static void main(String[] args) {
        Integer[] forArrayIterator = new Integer[]{1, 3, 67, 89, 222};
        ArrayIterator<Integer> arrayIterator = new ArrayIterator<>(forArrayIterator);
        withArrayIterator(arrayIterator);

        Integer[][] forMatrixIterator = new Integer[][]{};
        MatrixIterator<Integer> matrixIterator = new MatrixIterator<>(forMatrixIterator);
        withMatrixIterator(matrixIterator);
    }

    public static void withArrayIterator(ArrayIterator<Integer> arrayIterator) {
        while (arrayIterator.hasNext()) {
            System.out.println(arrayIterator.next());
        }
    }

    public static void withMatrixIterator(MatrixIterator<Integer> matrixIterator) {
        while (matrixIterator.hasNext()) {
            System.out.println(matrixIterator.next());
        }
    }
}
