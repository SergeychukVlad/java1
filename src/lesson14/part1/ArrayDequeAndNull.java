package lesson14.part1;

import java.util.ArrayDeque;

public class ArrayDequeAndNull {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        try {
            System.out.println("Пытаемся добавить null через add");
            deque.add(null);
        } catch (NullPointerException e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            System.out.println("Пытаемся добавить null через offer");
            deque.offer(null);
        } catch (NullPointerException e) {
            System.out.println(e.fillInStackTrace());
        }
        System.out.println(" --- резюме: НЕЛЬЗЯ добавить NULL к ArrayDeque через add() или offer()! Будет брошено NPE ---\n");

        try {
            System.out.println("Пытаемся посмотреть первый элемент очереди через element()");
            System.out.println("Первый элемент очереди " + deque.element());
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            System.out.println("Пытаемся взять элемент из пустой очереди через remove()");
            System.out.println("Взят элемент очереди " + deque.remove());
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        System.out.println(" --- резюме: методы element() и remove() бросят исключение ---\n");

        try {
            System.out.println("Пытаемся посмотреть первый элемент очереди через peek()");
            System.out.println("Первый элемент очереди " + deque.peek());
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        try {
            System.out.println("Пытаемся взять элемент из пустой очереди через poll()");
            System.out.println("Взят элемент очереди " + deque.poll());
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
        System.out.println(" --- резюме: методы peek() и poll() возвратят NULL ---");
    }
/* при работе с пустой очередью:
    - методы element() & remove() бросают исключение
    - методы peek() & poll() вернут NULL
*/
}
