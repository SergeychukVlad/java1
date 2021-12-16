package lesson14.part1;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class ArrayDequeVsLinkedListAsQueuePollTest {
    static final int ITERATIONS = 5000000;

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < ITERATIONS; i++) {
            deque.offer(i);
            linkedList.offer(i);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++)
            deque.poll();
        System.out.println("Получение ArrayDeque: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++)
            linkedList.poll();
        System.out.println("Получение LinkedList: " + (System.currentTimeMillis() - start));
    }
/*
Получение ArrayDeque: 101
Получение LinkedList: 570
*/
}
