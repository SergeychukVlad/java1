package lesson14.part2;

import java.util.ArrayDeque;

public class ArrayDequeAtFirstTest {
    static final int ITERATIONS = 5000000;

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        ArrayDeque<Integer> arrayDeque2 = new ArrayDeque<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) arrayDeque1.offer(i);  // аналог offerLast(i)
        System.out.println("Добавление в конец: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ITERATIONS; i++) arrayDeque2.offerFirst(i);
        System.out.println("Добавление в начало: " + (System.currentTimeMillis() - start));
    }
}
/*
Добавление в конец: 586
Добавление в начало: 765
 */
