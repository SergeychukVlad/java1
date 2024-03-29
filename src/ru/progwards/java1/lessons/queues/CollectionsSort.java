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

    private static List<Integer> getTestList() {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            testList.add(new Random().nextInt());
        }
        return testList;
    }


    public static void mySort(Collection<Integer> data) {
        Integer[] mayDataCopy = data.toArray(Integer[]::new);

        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (mayDataCopy[i] > mayDataCopy[j])
                    Collections.swap(Arrays.asList(mayDataCopy), i, j);
                else if (mayDataCopy[i].equals(mayDataCopy[j]))
                    j++;
            }
        }
        data.clear();
        Collections.addAll(data, mayDataCopy);
    }


    public static void minSort(Collection<Integer> data) {
        List<Integer> copyList = new ArrayList<>();
        int dataSize = data.size();

        for (int i = 0; i < dataSize; i++) {
            Integer min = Collections.min(data);
            data.remove(min);
            copyList.add(min);
        }
        data.addAll(copyList);
    }


    public static void collSort(Collection<Integer> data) {
        ArrayList<Integer> sortedData = new ArrayList<>(data);
        Collections.sort(sortedData);
        data.clear();
        data.addAll(sortedData);
    }


    public static Collection<String> compareSort() {
        List<Integer> testList = getTestList();
        String[] methodNames = new String[3];

        double start = System.currentTimeMillis();
        mySort(testList);
        methodNames[0] = System.currentTimeMillis() - start + "-mySort";

        start = System.currentTimeMillis();
        minSort(testList);
        methodNames[1] = (System.currentTimeMillis() - start) + "-minSort";

        start = System.currentTimeMillis();
        collSort(testList);
        methodNames[2] = (System.currentTimeMillis() - start) + "-collSort";

        Arrays.sort(methodNames, new Comparator<>() {
            @Override
            public int compare(String str1, String str2) {
                return Double.compare(
                        Double.parseDouble(str1.substring(0, str1.indexOf('-'))),
                        Double.parseDouble(str2.substring(0, str2.indexOf('-')))
                );
            }
        });

        for (int i = 0; i < methodNames.length; i++) {
            String methodName = methodNames[i];
            methodNames[i] = methodName.substring(methodName.indexOf("-") + 1);
        }

        return Arrays.asList(methodNames);
    }


    public static void main(String[] args) {
        System.out.println(compareSort());
    }

}
