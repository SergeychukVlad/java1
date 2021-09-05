/*
Interface Set.
Множество - коллекция, состоящая из уникальных элементов.

Отличия от List:
- элементы уникальные
- поиск, удаление - ОЧЕНЬ БЫСТРО
- редактировать ссылку (элемент) - невозможно
 */
package lesson13.part1;

import java.util.HashSet;

public class HashSetUnique {
    public static void main(String[] args) {
        HashSet<String> stringSet = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            stringSet.add("добавим");
            stringSet.add("в");
            stringSet.add("цикле");
            stringSet.add("в");
            stringSet.add("множество");
            stringSet.add("слова");
            stringSet.add("но");
            stringSet.add("одинаковых");
            stringSet.add("не");
            stringSet.add("встретим");
            stringSet.add("даже");
            stringSet.add("два");
        }
        System.out.println(stringSet);
        // получили список УНИКАЛЬНЫХ и НЕУПОРЯДОЧЕННЫХ элементов
    }
}
