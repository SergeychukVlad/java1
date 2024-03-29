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

Разные варианты решений.
 */



package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort_Variations {

    static final int ELEMENT_COUNT = 10;

    public static void mySort(Collection<Integer> data) {
        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (!(((List<Integer>) data).get(i) < ((List<Integer>) data).get(j))) {
                    Collections.swap((List<?>) data,
                            ((List<Integer>) data).indexOf(((List<Integer>) data).get(i)),
                            ((List<Integer>) data).indexOf(((List<Integer>) data).get(j)));
                } else if (((List<Integer>) data).get(i).equals(((List<Integer>) data).get(j))) {
                    j++;
                }
            }
        }
    }


    public static void mySortOnArray(Collection<Integer> data) {
        Integer[] mayDataCopy = data.toArray(Integer[]::new);

        for (int i = 0; i < data.size(); i++) {
            for (int j = i + 1; j < data.size(); j++) {
                if (mayDataCopy[i] > mayDataCopy[j]) {
                    mayDataCopy[i] = mayDataCopy[i] + mayDataCopy[j];       // без третьей переменной
                    mayDataCopy[j] = mayDataCopy[i] - mayDataCopy[j];
                    mayDataCopy[i] = mayDataCopy[i] - mayDataCopy[j];
//                    Collections.swap(Arrays.asList(mayDataCopy), i, j);     // или используя swap()
                } else if (mayDataCopy[i].equals(mayDataCopy[j]))
                    j++;
            }
        }
        System.out.println(Arrays.asList(mayDataCopy));

    }


    public static void mySortWithIterator(Collection<Integer> data) {
        ArrayList<Integer> dataCopy = new ArrayList<>(data);
        ListIterator<Integer> listIterator;
        int currentElement, previousElement, count;
        boolean sorted = false;

        while (!sorted) {
            count = 0;
            listIterator = dataCopy.listIterator();

            while (listIterator.hasNext()) {
                listIterator.next();
                previousElement = dataCopy.get(listIterator.previousIndex());

                if (listIterator.hasNext()) {
                    currentElement = dataCopy.get(listIterator.nextIndex());
                    if (previousElement > currentElement) {
                        Collections.swap(dataCopy, dataCopy.indexOf(previousElement), dataCopy.indexOf(currentElement));
                        count++;
                    }
                }
            }

            if (count == 0) sorted = true;
        }
    }


    public static void minSort(Collection<Integer> data) {
        List<Integer> copyList = new ArrayList<>();
        int size = data.size();
        for (int i = 0; i < size; i++) {
            Integer min = Collections.min(data);
            data.remove(min);
            copyList.add(min);
        }
        data.addAll(copyList);
    }


    public static void minSortWithIterator(Collection<Integer> data) {
        List<Integer> dataCopy = new ArrayList<>(data);
        List<Integer> dataResult = new ArrayList<>();
        ListIterator<Integer> listIterator = dataCopy.listIterator();

        while (listIterator.hasNext()) {
            Integer min = Collections.min(dataCopy);
            dataCopy.removeIf(r -> r.equals(min));
            dataResult.add(min);
        }
    }


    public static void collSort(Collection<Integer> data) {
        ArrayList<Integer> dataResult = new ArrayList<>(data);
        Collections.sort(dataResult);
        data.clear();
        data.addAll(dataResult);
    }


    public static Collection<String> compareSort() {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            Random random = new Random();
            testList.add(random.nextInt());
        }

        ArrayList<String> result = new ArrayList<>();
        long start;

        start = System.currentTimeMillis();
        mySort(testList);
        result.add((System.currentTimeMillis() - start) + "-mySort");

        start = System.currentTimeMillis();
        mySortWithIterator(testList);
        result.add((System.currentTimeMillis() - start) + "-mySortWithIterator");

        start = System.currentTimeMillis();
        minSort(testList);
        result.add((System.currentTimeMillis() - start) + "-minSort");

        start = System.currentTimeMillis();
        minSortWithIterator(testList);
        result.add((System.currentTimeMillis() - start) + "-minSortWithIterator");

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


    public static Collection<String> compareSortOnCollections() {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            testList.add(new Random().nextInt());
        }

        ArrayList<String> methodNameList = new ArrayList<>();

        double start = System.currentTimeMillis();
        mySort(testList);
        methodNameList.add((System.currentTimeMillis() - start) + "-mySort");

        start = System.currentTimeMillis();
        minSort(testList);
        methodNameList.add((System.currentTimeMillis() - start) + "-minSort");

        start = System.currentTimeMillis();
        collSort(testList);
        methodNameList.add((System.currentTimeMillis() - start) + "-collSort");

        methodNameList.sort(new Comparator<>() {
            @Override
            public int compare(String str1, String str2) {
                return Double.compare(
                        Double.parseDouble(str1.substring(0, str1.indexOf('-'))),
                        Double.parseDouble(str2.substring(0, str2.indexOf('-')))
                );
            }
        });

        System.out.println(methodNameList);

        for (int i = 0; i < methodNameList.size(); i++) {
            String methodName = methodNameList.get(i);
            methodNameList.set(i, methodName.substring(methodName.indexOf("-") + 1));
        }
        return methodNameList;
    }


    public static void main(String[] args) {
        System.out.println(compareSort());
    }
}

