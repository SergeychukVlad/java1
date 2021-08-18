/*
1.1 Реализовать метод
public static Collection<Integer> fillEven(int n) - создать коллекцию и заполнить последовательностью
четных возрастающих чисел начиная с 2, количество элементов в коллекции n

1.2 Реализовать метод
public static Collection<Integer> fillOdd(int n) - создать коллекцию и заполнить последовательностью
нечетных убывающих чисел, минимальное число в коллекции 1, количество элементов в коллекции n

1.3 Реализовать метод
public static Collection<Integer> fill3(int n) - создать коллекцию и заполнить ее тройками чисел.
Каждая тройка создается по алгоритму:
первое число тройки - индекс числа в коллекции,
второе - тот же индекс в квадрате,
третье - тот же индекс в кубе,
количество элементов в коллекции n*3
 */
package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Creator {
    static final int ELEMENT_COUNT = 6;

    public static Collection<Integer> fillEven(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++)
            arrayList.add(i, (i + 1) * 2);
        return arrayList;
    }

    public static Collection<Integer> fillOdd(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++)
            arrayList.add(i, (2 * i + 1));
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static Collection<Integer> fill3(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int i = 0;
        while (i < (n * 3)) {
            arrayList.add(i, i);
            arrayList.add(i + 1, (i * i));
            arrayList.add(i + 2, (i * i * i));
            i = i + 3;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println(fillEven(ELEMENT_COUNT));
        System.out.println(fillOdd(ELEMENT_COUNT));
        System.out.println(fill3(ELEMENT_COUNT));
    }
}
