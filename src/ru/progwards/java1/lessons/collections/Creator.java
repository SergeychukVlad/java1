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
import java.util.Arrays;
import java.util.Collection;

public class Creator {
    static final int ELEMENT_COUNT = 20;

    public static Collection<Integer> fillEven(int n) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < n; i++)
            arrayList.add(i, (i + 1) * 2);
        System.out.println(arrayList);
        return arrayList;
    }

    public static Collection<Integer> fillOdd(int n) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < n; i++)
            arrayList.add(i, (2 * i + 1));

        System.out.println(arrayList);
        return arrayList;
    }

    public static Collection<Integer> fill3(int n) {
        return Arrays.asList();
    }

    public static void main(String[] args) {

        fillEven(ELEMENT_COUNT);
        fillOdd(ELEMENT_COUNT);
//        fill3(10);
    }
}
