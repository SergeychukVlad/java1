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

        for (int i = 1; i < values.size() - 1; i++)
            // индексируем элементы массива sums[] так: индекс элемента в sums[] соответствует младшему индексу в паре
            // например, sums[0] - это максимум из пары values[0]/values[1]
            sums.add(values.get(i - 1) + values.get(i));
        return Arrays.asList(sums.indexOf(Collections.min(sums)), sums.indexOf(Collections.min(sums)) + 1);
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        ArrayList<Integer> values = new ArrayList<>(numbers);
        ArrayList<Integer> localMax = new ArrayList<>();

        for (int i = 1; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i - 1))
                if (values.get(i) > values.get(i + 1))
                    localMax.add(values.get(i));
        }
        return localMax;
    }

    public static boolean findSequence(Collection<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (!numbers.contains(i)) { // ищем единственное несовпадение. Если не находим - возвращаем из метода true.
                return false;
            }
        }
        return true;
    }

    public static String findSimilar(Collection<String> names) {
        ArrayList<String> arrayListNames = new ArrayList<>(names);  // список создан из коллекции names
        ArrayList<String> words = new ArrayList<>();                // список для хранения имён, которые есть в arrayListNames
        ArrayList<Integer> nTimes = new ArrayList<>();              // список для хранения числа повторений этих имён, соответственно

        String name;   // переменная хранения имён для записи в коллекцию words
        int j = 1;     // переменная хранения числа совпадений для конкретного элемента из коллекции words

        for (int i = 0; i < arrayListNames.size() - 1; i++) {
            if (arrayListNames.get(i).equals(arrayListNames.get(i + 1)))
                j++;
            else {
                name = arrayListNames.get(i);
                words.add(name);
                nTimes.add(j);
                j = 1;
            }
        }
        words.add(arrayListNames.get(arrayListNames.size() - 1));   // добавление последнего элемента в список имён
        nTimes.add(j);                                              // добавление последнего элемента в список числа совпадений
        // находим через indexOf() индекс максимального значения в списке числа повторений (nTimes)
        // По этому индексу - читаем имя в списке words
        return words.get(nTimes.indexOf(Collections.max(nTimes))) + ":"
                + nTimes.get(nTimes.indexOf(Collections.max(nTimes)));
    }

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 3, -2, 10, 45, 14, -6, 55, 19));
        ArrayList<Integer> myListForTrue = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<String> myStringList = new ArrayList<>(Arrays.asList("Тихон", "Таня", "Тихон", "Тихон", "Толя", "Толя", "Толя", "Таня", "Таня", "Таня", "Алекс"));
        ArrayList<String> myTestList = new ArrayList<>(Arrays.asList("Григорий", "Александр", "Борис", "Григорий",
                "Василий", "Борис", "Василий", "Борис", "Дмитрий", "Григорий", "Александр", "Василий", "Григорий",
                "Дмитрий", "Василий", "Александр", "Александр"));

        System.out.println("findMinSumPair(): " + findMinSumPair(myList));

        System.out.println("findLocalMax(): " + findLocalMax(myList));

        System.out.println("findSequence(): " + findSequence(myList));
        System.out.println("findSequence(): " + findSequence(myListForTrue));

        System.out.println("findSimilar(): " + findSimilar(myStringList));
        System.out.println("findSimilar(): " + findSimilar(myTestList));
    }
}
