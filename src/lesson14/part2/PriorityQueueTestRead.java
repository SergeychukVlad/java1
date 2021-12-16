package lesson14.part2;

import java.util.*;

public class PriorityQueueTestRead {
    static final int ELEMENT_COUNT = 5000000;

    public static void main(String[] args) {
        PriorityQueue<Double> priQueue = new PriorityQueue<>();
        ArrayList<Double> arrayList = new ArrayList<>();

        Random rnd = new Random();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            priQueue.offer(rnd.nextDouble());
            arrayList.add(rnd.nextDouble());
        }
        Collections.sort(arrayList);
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++) priQueue.poll();
        System.out.println("Чтение элементов из PriorityQueue: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++) arrayList.get(i);
        System.out.println("Чтение элементов из ArrayList: " + (System.currentTimeMillis() - start));
    }
}
/*
Чтение элементов из PriorityQueue: 13005
Чтение элементов из ArrayList: 20
 */
