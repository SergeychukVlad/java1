/*
Ключевую роль в TreeSet играет компаратор.
В данном случаем находится в классе-оболочке Integer.
compareTo(obj1, obj2) возвращает:
0 : когда объекты obj1 и obj2 равны
1 : когда obj1 > obj2
-1: когда obj1 < obj2

Сравнение элементов в TreeSet производится при помощи компаратора, а не equals()
*/
package lesson13.part3;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetDescending {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(2);

        TreeSet<Integer> treeSetOnCollection = new TreeSet<>(List.of(1, -3, 6, 8, 0, -4, 4));

        System.out.println("treeSet: " + treeSet);
        System.out.println("treeSetOnCollection: " + treeSetOnCollection);
        System.out.print("Descending order for treeSetOnCollection:");
        Iterator<Integer> descIter = treeSetOnCollection.descendingIterator();
        while (descIter.hasNext()) {
            System.out.print(" " + descIter.next());
        }
    }
}
