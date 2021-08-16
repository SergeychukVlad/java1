/*
1. Ваш ответ верный.
Правильные ответы:
ListIterator позволяет добавлять, удалять и менять элементы списка,
ListIterator позволяет двигаться по списку в обе стороны,
ListIterator отличается от Iterator расширенным набором функций

2.
Правильный ответ:
        for (ListIterator<integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
            Integer n = listIterator.next();
            if ( n%2 != 0)
                listIterator.set(n*2);
//---------------------------------------
→ 0 2 2 6 4,

        for (ListIterator<integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
            Integer n = listIterator.next();
            if ( n%2 != 0)
                listIterator.remove();
            else
                listIterator.add(n*2);
//---------------------------------------
→ 0 0 2 4 4 8
 */
package lesson12.part3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Answer_part3_3 {

    public static void iterator3(ListIterator<Integer> iterator) {
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value % 3 == 0) {
                iterator.set(iterator.nextIndex() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList(Arrays.asList(12, 7, 55, 8, 11, 171, 9));
        ListIterator<Integer> iterator = linkedList.listIterator();
        iterator3(iterator);
        System.out.println(linkedList);
    }
}
