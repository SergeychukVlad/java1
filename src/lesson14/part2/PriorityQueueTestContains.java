package lesson14.part2;

import java.util.*;

public class PriorityQueueTestContains {
    static final int ELEMENT_COUNT = 5000000;

    public static void main(String[] args) {
        PriorityQueue<Double> priQueue = new PriorityQueue<>();
        TreeSet<Double> treeSet = new TreeSet<>();

        Random rnd = new Random();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            priQueue.offer(rnd.nextDouble());
            treeSet.add(rnd.nextDouble());
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) priQueue.contains(rnd.nextDouble());
        System.out.println("Поиск элементов в PriorityQueue: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) treeSet.contains(rnd.nextDouble());
        System.out.println("Поиск элементов в TreeSet: " + (System.currentTimeMillis() - start));
    }
}
/*
Поиск элементов в PriorityQueue: 48748
Поиск элементов в TreeSet: 7
 */
