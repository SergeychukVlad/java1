package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    private int currentIndex = 0;

    @Override
    public boolean hasNext() {
        return currentIndex < this.array.length && array[currentIndex] != null;
    }

    @Override
    public T next() {
        return array[currentIndex++];
    }
}
