/*
Класс MatrixIterator
Сделать итератор MatrixIterator по двумерному массиву (матрице), который разворачивает матрицу
в линейную последовательность построчно: a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]

Шаблон для итератора взять от ArrayIterator
 */
package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[] array;

    public MatrixIterator(T[][] arrayAsParam) {
        int k = 0;                                  // счётчик одномерного массива
        int size = arrayAsParam.length              // размер одномерного массива: кол-во строк
                * arrayAsParam[0].length;           // * кол-во столбцов

        T[] oneSizeArray = (T[]) new Object[size];  // создаю одномерный массив для "укладки" элементов двухмерного

        while (k < size) {
            for (T[] ts : arrayAsParam) {
                for (int i = 0; i < arrayAsParam.length; i++) {
                    oneSizeArray[k] = ts[i];
                    k++;
                }
            }
        }
        this.array = oneSizeArray;
    }
    // дальше всё, как в ArrayIterator
    private int currentIndexI = 0;

    @Override
    public boolean hasNext() {
        return currentIndexI < this.array.length && array[currentIndexI] != null;
    }

    @Override
    public T next() {
        return array[currentIndexI++];
    }
}
