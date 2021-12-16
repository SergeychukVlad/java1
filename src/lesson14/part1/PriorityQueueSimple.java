package lesson14.part1;

import java.util.PriorityQueue;

public class PriorityQueueSimple {
    public static void main(String[] args) {
        PriorityQueue<Integer> priQueue = new PriorityQueue<>();
        priQueue.offer(144);
        priQueue.offer(21);
        priQueue.offer(377);
        priQueue.offer(89);
        priQueue.offer(34);
        priQueue.offer(233);
        priQueue.offer(55);

        while (!priQueue.isEmpty()) {
            System.out.println(priQueue.poll());
        }
    }
}
