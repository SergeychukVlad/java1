package lesson12.part3;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Answer_part3_2 {

    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < 5; i++)
            linkedList.add(i);
        System.out.println(linkedList);

        for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
            Integer n = listIterator.next();
            if (n % 2 != 0) {
                listIterator.set(n * 2);
            }
        }
        System.out.println(linkedList);

        for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
            Integer n = listIterator.next();
            if (n % 2 != 0) {
                listIterator.remove();
            }
            else {
                listIterator.add(n * 2);
            }
        }
        System.out.println(linkedList);

    }
}
