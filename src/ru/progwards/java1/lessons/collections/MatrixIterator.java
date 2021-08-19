package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T> {

    private T[][] array;

    public MatrixIterator(T[][] array) {
        this.array = array;
    }

    private int currentIndexI = 0;
    private int currentIndexJ = 0;

    @Override
    public boolean hasNext() {
        return (currentIndexI < this.array.length && array[currentIndexI] != null)
                && (currentIndexJ < this.array.length && array[currentIndexJ] != null);
    }

    @Override
    public T next() {
        return array[currentIndexI++][currentIndexJ++];
    }
}
