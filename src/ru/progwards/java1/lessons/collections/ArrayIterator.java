/*
Класс ArrayIterator
Сделать итератор по одномерному массиву, реализовать методы hasNext() и next(). Шаблон пустого итератора:
	public class ArrayIterator<T> implements Iterator<T> {
		private T[] array;
		ArrayIterator(T[] array) {
			this.array = array;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}
	}
 */
package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

    private int currentIndex = 0;
    private final T[] array;

    public ArrayIterator(T[] arrayAsParam) {
        this.array = arrayAsParam;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < this.array.length && array[currentIndex] != null;
    }

    @Override
    public T next() {
        return array[currentIndex++];
    }
}
