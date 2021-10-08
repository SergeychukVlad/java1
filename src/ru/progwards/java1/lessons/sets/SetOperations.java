/*
Реализовать класс SetOperations, операции над множествами целых чисел.
1.1 Метод public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) - объединение множеств
1.2 Метод public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) - пересечение множеств
1.3 Метод public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) - разница множеств
1.4 Метод public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) - симметрическая разница
Кто подзабыл что значит каждая операция, можно глянуть тут
https://studopedia.ru/14_138615_operatsii-nad-mnozhestvami-i-ih-svoystva.html или OK - google
 */
package ru.progwards.java1.lessons.sets;

import java.util.Set;
import java.util.TreeSet;

public class SetOperations {

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new TreeSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new TreeSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static Set<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new TreeSet<>(set1);
        result.removeAll(intersection(set1, set2));
        return result;
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new TreeSet<>(union(set1, set2));
        result.removeAll(intersection(set1, set2));
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = Set.of(1, -3, 6, 8, 0, -4, 4);
        Set<Integer> set2 = Set.of(-9, -7, -1, 19, 7, 10, -4, 4, 0);

        System.out.println(union(set1, set2));
        System.out.println(intersection(set1, set2));
        System.out.println(difference(set1, set2));
        System.out.println(symDifference(set1, set2));
    }
}
