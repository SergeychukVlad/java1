/*
2.1 Реализовать метод
public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) - найти 2 соседних числа в коллекции
сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел.

2.2 Реализовать метод
public static Collection<Integer> findLocalMax(Collection<Integer> numbers) - найти локальные максимумы - числа,
которые больше соседа справа и слева. Первый и последний элемент коллекции не может являться локальным  максимумом,
вернуть коллекцию, содержащую значения этих максимумов

2.3 Реализовать метод
public static boolean findSequence(Collection<Integer> numbers) - проверить, содержит ли коллекция все числа
от 1 до size(), порядок может быть произвольный

2.4 Реализовать метод
public static String findSimilar(Collection<String> names) - найдите максимальное количество повторяющихся подряд
элементов. Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
При равенстве максимального количества у разных повторяющихся элементов, вернуть результат для элемента,
повторяющаяся последовательность которого началась с наименьшего индекса.
 */
package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        ArrayList<Integer> values = new ArrayList<>(numbers);
        ArrayList<Integer> sums = new ArrayList<>();

        for (int i = 1; i < values.size() - 1; i++) {
            // индексируем элементы массива sums[] так: индекс элемента в sums[] соответствует младшему индексу в паре
            // например, sums[0] - это максимум из пары values[0]/values[1]
            sums.add(values.get(i - 1) + values.get(i));
        }
        return Arrays.asList(sums.indexOf(Collections.min(sums)), sums.indexOf(Collections.min(sums)) + 1);
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        ArrayList<Integer> values = new ArrayList<>(numbers);
        ArrayList<Integer> localMax = new ArrayList<>();

        for (int i = 1; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i - 1)) {
                if (values.get(i) > values.get(i + 1)) {
                    localMax.add(values.get(i));
                }
            }
        }
        return localMax;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.contains(i) == false) {
                return false;
            }
        }
        return true;
    }

    public static String findSimilar(Collection<String> names) {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 3, -2, 10, 45, 14, -6, 55, 19));
//        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(0, 1, 2, 3));

        System.out.println("findMinSumPair(): " + findMinSumPair(myList));
        System.out.println("findLocalMax(): " + findLocalMax(myList));
        System.out.println("findSequence(): " + findSequence(myList));
//        findSimilar(myList);
    }
}
