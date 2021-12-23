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

    public static void mySort(Collection<Integer> data) {
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

    public static void mySortWithIterator(Collection<Integer> data) {
        ArrayList<Integer> dataCopy = new ArrayList<>(data);
        ListIterator<Integer> listIterator;
        Integer currentElement, previousElement;
        boolean sorted = false;
        int iter = 0;

        while (!sorted) {
            listIterator = dataCopy.listIterator();

            while (listIterator.hasNext()) {
                listIterator.next();
                previousElement = dataCopy.get(listIterator.previousIndex());

                if (listIterator.hasNext()) {
                    currentElement = dataCopy.get(listIterator.nextIndex());
                    if (previousElement >= currentElement) {
                        Collections.swap(dataCopy, dataCopy.indexOf(previousElement), dataCopy.indexOf(currentElement));
                        iter++;
                    } else iter = 0;
                }

            }
            if (iter == 0) sorted = true;
        }
        System.out.println(dataCopy);
    }

    public static void minSort(Collection<Integer> data) {
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

    public static void minSortWithIterator(Collection<Integer> data) {
        List<Integer> dataResult = new ArrayList<>();
        List<Integer> dataCopy = new ArrayList<>(data);
        ListIterator<Integer> listIterator = dataCopy.listIterator();

        while (listIterator.hasNext()) {
            Integer min = Collections.min(dataCopy);
            dataResult.add(min);
            dataCopy.removeIf(r -> r.equals(min));
        }
        data = new ArrayList<>(dataResult);
        System.out.println(data);
    }

    public static void collSort(Collection<Integer> data) {
    }

    public static Collection<String> compareSort() {
        return null;
    }

    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            testList.add(new Random().nextInt());
        }

        System.out.print("mySort:              ");
        mySort(testList);

        System.out.print("mySortWithIterator:  ");
        mySortWithIterator(testList);

        System.out.print("minSort:             ");
        minSort(testList);

        System.out.print("minSortWithIterator: ");
        minSortWithIterator(testList);
    }
}
