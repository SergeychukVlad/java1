package lesson12.part2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static LinkedList creation() {
        System.out.println("работает " + new Throwable().getStackTrace()[0].getMethodName() + "...");
        List linkedList = new LinkedList<Integer>(Arrays.asList(20, 30, 40));
        System.out.println(linkedList);
        return (LinkedList) linkedList;
    }

    public static LinkedList action(LinkedList linkedList) {
        System.out.println("работает " + new Throwable().getStackTrace()[0].getMethodName() + "...");
        linkedList.add(1, 25);
        System.out.println("добавление в середину: " + linkedList);
        linkedList.remove(2);
        System.out.println("удаление из середины: " + linkedList);
        System.out.println("обращение к элементу: " + linkedList.get(2));
        System.out.println(linkedList);
        return linkedList;
    }

    public static void specific(LinkedList linkedList) {
        System.out.println("работает " + new Throwable().getStackTrace()[0].getMethodName() + "...");
        linkedList.push(100);
        System.out.println("вставить элемент в начало - push(100): " + linkedList);
        linkedList.poll();
        System.out.println("взять первый элемент и удалить его - pool: " + linkedList);
        linkedList.pollLast();
        System.out.println("взять последний элемент и удалить его - poolLast: " + linkedList);
//        linkedList.removeIf(s->s > 25);
//        System.out.println("удалить элементы по условию- removeIf: " + linkedList);
    }

    public static void main(String[] args) {
    /*
        выводы по скорости LinkedList:
        -доступ в начало/конец списка - быстро!
        -доступ в середину списка - медленно()
        -add в начало/конец списка - быстро!
        -add в середину списка - медленно(медленный доступ по индексу)
        -remove первого/последнего элемента - быстро!
        -remove в середине списка - медленно(медленный доступ по индексу)
    */

        specific(action(creation()));
    }
}
