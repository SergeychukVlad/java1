/*
Класс MatrixIterator
Сделать итератор MatrixIterator по двумерному массиву (матрице), который разворачивает матрицу
в линейную последовательность построчно: a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]

Шаблон для итератора взять от ArrayIterator
 */
package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MatrixIterator<T> implements Iterator<T> {

    private final List<T> arrayList;

    public MatrixIterator(T[][] arrayAsParam) {
        List<T> list = new ArrayList<>();
        for (int m = 0; m < arrayAsParam.length; m++) {
            for (int n = 0; n < arrayAsParam.length; n++) {
                list.add(arrayAsParam[m][n]);
            }
        }
        this.arrayList = list;
    }

    // дальше всё, как в ArrayIterator
    private int currentIndexI = 0;

    @Override
    public boolean hasNext() {
        return currentIndexI < this.arrayList.size() && arrayList.get(currentIndexI) != null;
    }

    @Override
    public T next() {
        return arrayList.get(currentIndexI++);
    }
}