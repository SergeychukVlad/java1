package lesson14.part1;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class TestAnswer {

    /*
Выберите верные утверждения насчет очередей с интерфейсом Queue

Выберите один или несколько ответов:
a. Очередь работает по принципу LIFO - Last In First Out
b. Очередь работает по принципу FIFO - First In First Out +
c. peek и pool бросают исключения
d. ArrayDeque быстро добавляет элементы в конец очереди +
e. element и remove бросают исключения +
     */

    static void dequeueTest() {
        ArrayDeque deque = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            deque.offer(i);
            if (i % 2 == 0)
                deque.poll();
        }

        System.out.println(deque);
    }

    static void pqTest() {
        PriorityQueue pQueue = new PriorityQueue<>();
        pQueue.offer(10);
        pQueue.offer(1);
        pQueue.offer(9);
        pQueue.offer(3);
        System.out.println(pQueue);
    }

    static ArrayDeque<Integer> array2queue(int[] a) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            result.offer(a[i]);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        dequeueTest();
        pqTest();
        int[] a = {1, 2, 5, 7, 8};
        array2queue(a);
    }
}
