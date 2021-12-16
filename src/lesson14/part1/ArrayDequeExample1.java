package lesson14.part1;

import java.util.ArrayDeque;

public class ArrayDequeExample1 {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <=5; i++) {
            deque.offer(i);
        }
        System.out.println(deque);

        while (!deque.isEmpty()) {
            Integer element = deque.poll();
            System.out.println("Убрали элемент: " + element);
            System.out.println(deque);
        }
    }
}