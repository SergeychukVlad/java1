/*
Итератор для множества
 */
package lesson13.part1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIteratorRemove {
    final static String TEXT = "на дворе трава на траве дрова Не руби дрова на траве двора";

    public static void main(String[] args) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));
        System.out.println(wordSet);

        Iterator<String> iterator = wordSet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().contains("трав")) {
                iterator.remove();
            }
        }
        System.out.println(wordSet);
    }
}
