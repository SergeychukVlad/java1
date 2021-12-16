package lesson14.part2;

import java.util.*;

public class PriorityQueueTest {
    static final int ELEMENT_COUNT = 5000000;

    public static void main(String[] args) {
        PriorityQueue<Double> priQueue = new PriorityQueue<>();
        TreeSet<Double> treeSet = new TreeSet<>();
        ArrayList<Double> arrayList = new ArrayList<>();

        Random rnd = new Random();

        long start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++) priQueue.offer(rnd.nextDouble());
        System.out.println("Добавление в PriorityQueue: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++) treeSet.add(rnd.nextDouble());
        System.out.println("Добавление в TreeSet: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++) arrayList.add(rnd.nextDouble());
        Collections.sort(arrayList);
        System.out.println("Добавление и сортировка в ArrayList: " + (System.currentTimeMillis() - start));
    }
}
/*
Добавление в PriorityQueue: 1649
Добавление в TreeSet: 13347
Добавление и сортировка в ArrayList: 9809
 */
