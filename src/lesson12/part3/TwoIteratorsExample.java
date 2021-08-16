package lesson12.part3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TwoIteratorsExample {
    static final int ELEMENT_COUNT = 5;

    public static void twoIteratorsOnListIterator() {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " работает... ");

        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            linkedList.add(i + 1);
        }

        ListIterator<Integer> iterator1 = linkedList.listIterator();
        ListIterator<Integer> iterator2 = linkedList.listIterator(linkedList.size());

        while (iterator1.hasNext() && iterator2.hasPrevious()) {
            Integer intObj1 = iterator1.next();
            Integer intObj2 = iterator2.previous();

            System.out.println("Итератор1 вернул " + intObj1);
            System.out.println("Итератор2 вернул " + intObj2 + "\n");
        }
    }

    public static void twoIteratorsOnStandardIterator() {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " работает... ");

        // Внимание! Используем LinkedList. Потому как в нём есть метод descendingIterator().
        LinkedList<Integer> linkedList = new LinkedList();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            linkedList.add(i + 1);
        }

        Iterator<Integer> iterator1 = linkedList.iterator();
        Iterator<Integer> iterator2 = linkedList.descendingIterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            Integer intObj1 = iterator1.next();
            Integer intObj2 = iterator2.next();

            System.out.println("Итератор1 вернул " + intObj1);
            System.out.println("Итератор2 вернул " + intObj2 + "\n");
        }
    }

    public static void main(String[] args) {
        // ожидаем идентичные результаты
        twoIteratorsOnListIterator();
        System.out.println();
        twoIteratorsOnStandardIterator();
    }
}
