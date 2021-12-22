package lesson14.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsCopy {
    public static void main(String[] args) {
//        пример добавления нескольких объектов
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 3, 2, 1, 4, 6, 8);
        System.out.println(list);

//        пример копирования списка в другой список
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            linkedList.add(0);
        Collections.copy(linkedList, list);
        System.out.println(linkedList);
    }
}
