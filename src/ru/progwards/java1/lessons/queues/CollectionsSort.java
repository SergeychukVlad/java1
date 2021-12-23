/*
Задача 1. Класс CollectionsSort
Сравнение методов сортировки коллекций
1.1 Реализовать метод public static void mySort(Collection<Integer> data) - переделать алгоритм из класса ArraySort
из ДЗ про массивы, на коллекции. Не использовать встроенные методы сортировок

1.2 Реализовать метод public static void minSort(Collection<Integer> data) по следующему алгоритму
- создать новую коллекцию
- найти минимальный элемент с использованием функции min()
- переместить его в новую коллекцию
- делать так до тех пор, пока все элементы не окажутся в новой коллекции
- скопировать новую коллекцию в старую

1.3 Реализовать метод public static void collSort(Collection<Integer> data) используя метод sort из Collections

1.4 Реализовать метод public static Collection<String> compareSort() в котором сравнить производительность методов
и вернуть их имена, отсортированные в порядке производительности, первый - самый быстрый.
В случае равенства производительности каких-то методов, возвращать их названия в алфавитном порядке.
 */

package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    static final int ELEMENT_COUNT = 500;

    public static void mySortOld(Collection<Integer> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (!(((List<Integer>) data).get(i) <= ((List<Integer>) data).get(j))) {
                    Collections.swap((List<?>) data,
                            ((List<Integer>) data).indexOf(((List<Integer>) data).get(i)),
                            ((List<Integer>) data).indexOf(((List<Integer>) data).get(j)));
                }
            }
        }
        System.out.println(data);
    }

    public static void mySort(Collection<Integer> data) {
        ArrayList<Integer> dataCopy = new ArrayList<>(data);
        ListIterator<Integer> listIterator;
        Integer currentElement, previousElement;
        boolean sorted = false;
        int iter;

        while (!sorted) {
            iter = 0;
            listIterator = dataCopy.listIterator();

            while (listIterator.hasNext()) {
                listIterator.next();
                previousElement = dataCopy.get(listIterator.previousIndex());

                if (listIterator.hasNext()) {
                    currentElement = dataCopy.get(listIterator.nextIndex());
                    if (previousElement > currentElement) {
                        Collections.swap(dataCopy, dataCopy.indexOf(previousElement), dataCopy.indexOf(currentElement));
                        iter++;
                    }
                }
            }

            if (iter == 0) sorted = true;
        }
//        System.out.println(dataCopy);
    }

    public static void minSortOld(Collection<Integer> data) {
        List<Integer> dataResult = new ArrayList<>();
        List<Integer> dataCopy = new ArrayList<>(data);
        int dataSize = data.size();

        for (int i = 0; i < dataSize; i++) {
            Integer min = Collections.min(dataCopy);
            dataCopy.removeIf(r -> r.equals(min));
            dataResult.add(min);
        }
        System.out.println(dataResult);
    }

    public static void minSort(Collection<Integer> data) {
        List<Integer> dataResult = new ArrayList<>();
        List<Integer> dataCopy = new ArrayList<>(data);
        ListIterator<Integer> listIterator = dataCopy.listIterator();

        while (listIterator.hasNext()) {
            Integer min = Collections.min(dataCopy);
            dataResult.add(min);
            dataCopy.removeIf(r -> r.equals(min));
        }
//        data = new ArrayList<>(dataResult);
//        System.out.println(dataResult);
    }

    public static void collSort(Collection<Integer> data) {
        ArrayList<Integer> list = new ArrayList<>(data);
        Collections.sort(list);
//        System.out.println(list);
    }

    public static Collection<String> compareSort() {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            Random random = new Random();
            testList.add(random.nextInt());
        }

        long start = System.currentTimeMillis();
        System.out.print("mySort:              ");
        mySort(testList);
        System.out.println("затрачено - " + (System.currentTimeMillis() - start));

//        start = System.currentTimeMillis();
//        System.out.print("mySortWithIterator:  ");
//        mySortWithIterator(testList);
//        System.out.println("затрачено - " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.print("minSort:             ");
        minSort(testList);
        System.out.println("затрачено - " + (System.currentTimeMillis() - start));

//        start = System.currentTimeMillis();
//        System.out.print("minSortWithIterator: ");
//        minSortWithIterator(testList);
//        System.out.println("затрачено - " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.print("collSort:            ");
        collSort(testList);
        System.out.println("затрачено - " + (System.currentTimeMillis() - start));
    }
}
