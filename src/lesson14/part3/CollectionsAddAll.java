package lesson14.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CollectionsAddAll {
    public static void main(String[] args) {
//        пример добавления нескольких объектов в список
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 4, 3, 2, 6, 9);
        System.out.println(list);

//        пример добавления массива в PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Integer[] integers = new Integer[list.size()];
        list.toArray(integers);
        Collections.addAll(queue, integers);
        System.out.println(queue);
    }

}
