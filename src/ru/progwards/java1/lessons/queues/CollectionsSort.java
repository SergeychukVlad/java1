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
    }

    public static void minSort(Collection<Integer> data) {
        List<Integer> copyList = new ArrayList<>();
        int size = data.size();
        for (int i = 0; i < size; i++) {
            Integer min = Collections.min(data);
            data.removeIf(r -> r.equals(min));
            copyList.add(min);
        }
        data.addAll(copyList);
    }

    public static void collSort(Collection<Integer> data) {
        ArrayList<Integer> dataResult = new ArrayList<>(data);
        Collections.sort(dataResult);
        data.clear();
        data.addAll(dataResult);
    }

    public static Collection<String> compareSort() {
        List<Integer> testList = new ArrayList<>(Arrays.asList(1, 12, -9, 5, -10));
        ArrayList<String> result = new ArrayList<>();
        long start;

        start = System.currentTimeMillis();
        mySort(testList);
        result.add((System.currentTimeMillis() - start) + "-mySort");

        start = System.currentTimeMillis();
        minSort(testList);
        result.add((System.currentTimeMillis() - start) + "-minSort");

        start = System.currentTimeMillis();
        collSort(testList);
        result.add((System.currentTimeMillis() - start) + "-collSort");

        result.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return Long.compare(Long.parseLong(o1.substring(0, o1.indexOf('-'))),
                        Long.parseLong(o2.substring(0, o2.indexOf('-'))));
            }
        });

        ListIterator<String> listIterator = result.listIterator();
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            String[] parts = next.split("-");
            listIterator.set(next.replace(next, parts[1]));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(compareSort());
    }
}
