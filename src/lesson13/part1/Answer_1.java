/*
1. Ваш ответ частично правильный.
Вы правильно выбрали 3.
Правильные ответы:
- Содержит только уникальные элементы,
- Добавление элемента происходит чуть медленнее, чем в список,
- Поиск по ключу происходит значительно быстрее, чем в списке,
- Удаление элемента происходит быстрее, чем в списке

2-5. Задачи-методы этого класса
 */
package lesson13.part1;

import java.util.*;

public class Answer_1 {
    public static void iSetTest() {
        Set<Integer> iSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                iSet.add(i + j);
            }
        System.out.println(iSet.size());
    }

    public static void wSetTest() {
        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));

        Iterator<String> iter = wordSet.iterator();
        while (iter.hasNext())
            if (iter.next().contains("ра"))
                iter.remove();

        System.out.println(wordSet.size());
    }

    public static void cset() {
        Set<Integer> fiboSet1000 =
                Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        int sum = 0;
        for (int i = 2; i < 10; i++)
            sum += fiboSet1000.contains(i) ? 1 : 0;
        System.out.println(sum);
    }

    public static Set<Integer> a2set(int[] a) {
        Set<Integer> intSet = new HashSet<>();
        for (int j : a) {
            intSet.add(j);
        }
        return intSet;
    }

    public static void main(String[] args) {
        iSetTest();
        wSetTest();
        cset();
        int[] a = {1, 5, 80, 7};
        a2set(a);
    }
}
