package lesson12.part1;

import java.util.ArrayList;
import java.util.List;

/*
Добавление объекта
 */
public class ArrayListAdd {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(1);   // --
        arrayList.add(2);   //  |
        arrayList.add(3);   //  - метод интерфейса Collection
        arrayList.add(4);   //  |
        arrayList.add(5);   // --

        arrayList.add(0, 8);    // метод интерфейса List

        for (Integer i : arrayList) {
            System.out.println(i);
        }
    }
}
