/*
Добавление элементов в HashSet и ArrayList
*/
package lesson13.part1;

import java.util.*;

public class SearchTestForSetAndList {
    final static int ELEMENT_COUNT = 2_000_000;

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Set<Integer> intSet = new HashSet<>();

        for (int i = 0; i < ELEMENT_COUNT; i++) {
            intList.add(i);
            intSet.add(i);
        }

        var startTime = new Date().getTime();
        for (int i = 0; i < ELEMENT_COUNT; i += 1000) {
            intList.contains(i);
        }
        System.out.println("Searching for ArrayList: " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        for (int i = 0; i < ELEMENT_COUNT; i += 1000) {
            intSet.contains(i);
        }
        System.out.println("Searching for HashSet: " + (new Date().getTime() - startTime));

    }
}
/*
Результат - Set в тысячи раз быстрее! - 4 vs 35000 на выборке 2000 элементов.
 */