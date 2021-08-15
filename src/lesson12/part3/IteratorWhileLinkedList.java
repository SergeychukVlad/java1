package lesson12.part3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorWhileLinkedList {
    static final int ELEMENT_COUNT = 5;

    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            linkedList.add(i + 1);
        }

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer intObj = iterator.next();
            System.out.println("Значение элемента = " + intObj);
        }
    }
}
