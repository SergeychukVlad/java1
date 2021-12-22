package lesson14.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsFillAndCopy {
    public static void main(String[] args) {
//  пример добавления нескольких объектов
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 3, 2, 1, 4, 6, 8);
        System.out.println(list);
//  заполнение коллекции одним объектом
        Collections.fill(list, 5);
        System.out.println(list);
//  создание новой immutable collection из 5 одинаковых элементов
        List<Integer> copiesList = Collections.nCopies(5, 10);
        System.out.println(copiesList);
    }
}
