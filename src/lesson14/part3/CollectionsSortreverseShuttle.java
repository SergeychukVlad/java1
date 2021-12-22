package lesson14.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSortreverseShuttle {
    public static void main(String[] args) {
//        пример добавления нескольких объектов в список
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 4, 3, 2, 6, 9);
        System.out.println(list);
//        сортировка
        Collections.sort(list);
        System.out.println(list);
//        сортировка в обратном порядке
        Collections.reverse(list);
        System.out.println(list);
//        перемешать в случайном порядке
        Collections.shuffle(list);
        System.out.println(list);
    }
}
