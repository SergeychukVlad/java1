package lesson14.part1;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class ArrayDequeVsLinkedListAsQueueTest {
    static final int ITERATIONS = 5000000;

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++)
            deque.offer(i);
        System.out.println("Наполнение ArrayDeque: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++)
            linkedList.offer(i);
        System.out.println("Наполнение LinkedList: " + (System.currentTimeMillis() - start));
    }
/*
Наполнение ArrayDeque: 592
Наполнение LinkedList: 1187
*/
}
