/*
Удалить все чётные элементы
 */
package lesson12.part3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorChangeList {
    static final int ELEMENT_COUNT = 5;

    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList();

        for (int i = 0; i < ELEMENT_COUNT; i++) {
            linkedList.add(i + 1);
        }

        System.out.println("Список до изменения: ");
        for (Integer intObj : linkedList) {
            System.out.println("Значение элемента = " + intObj);
        }

        for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
            Integer intObj = listIterator.next();
            listIterator.set(intObj * intObj);
        }

        System.out.println("Список после изменения: ");
        for (Integer intObj : linkedList) {
            System.out.println("Значение элемента = " + intObj);
        }
    }
}
