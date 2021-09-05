/*
Добавление элементов в HashSet и ArrayList
*/
package lesson13.part1;

import java.util.*;

public class AddToSetAndArrayListTest {
    final static int ELEMENT_COUNT = 500_000;

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Set<Integer> intSet = new HashSet<>();

        var startTime = new Date().getTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            intList.add(i);
        }
        System.out.println("Adding to ArrayList: " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            intSet.add(i);
        }
        System.out.println("Adding to HashSet: " + (new Date().getTime() - startTime));

    }
}
/*
Результат - вполне сопоставимо. Отличия в 2...3 раза.
 */