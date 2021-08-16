/*
Тестирование операции "Добавить элементы РОВНО в середину" для ArrayList / LinkedList
 */

package lesson12.part3;

import java.util.*;

public class ListIteratorCenterTest {
    static final int ELEMENT_COUNT = 50_000;

    public static void main(String[] args) {
        System.out.println("Количество записей - " + ELEMENT_COUNT + "\n");
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        List<Integer> arrayList = new ArrayList();
        var startTime = new Date().getTime();

        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        System.out.println("Добавление в середину ArrayList: " + (new Date().getTime() - startTime));

        List<Integer> linkedList = new LinkedList();
        startTime = new Date().getTime();
        ListIterator<Integer> listIterator = linkedList.listIterator();

        for (int i = 0; linkedList.size() < ELEMENT_COUNT; i++) {
            if (listIterator.previousIndex() >= linkedList.size() / 2) {
                listIterator.previous();
            }
            listIterator.add(i);
        }
        System.out.println("Добавление в середину LinkedList через ListIterator: " + (new Date().getTime() - startTime));
    }
}
/*
вывод: Данная СПЕЦИФИЧЕСКАЯ операция ОЧЕНЬ быстро выполняется на LinkedList + ListIterator
 */