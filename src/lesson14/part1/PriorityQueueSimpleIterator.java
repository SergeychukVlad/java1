package lesson14.part1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueSimpleIterator {
    public static void main(String[] args) {
        PriorityQueue<Integer> priQueue = new PriorityQueue<>();
        priQueue.offer(144);
        priQueue.offer(21);
        priQueue.offer(377);
        priQueue.offer(89);
        priQueue.offer(34);
        priQueue.offer(233);
        priQueue.offer(55);

        System.out.println("iterator:");
        Iterator<Integer> iterator = priQueue.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
        System.out.println("\npoll");
        while (!priQueue.isEmpty()) {
            System.out.println(priQueue.poll());
        }
    }
}
