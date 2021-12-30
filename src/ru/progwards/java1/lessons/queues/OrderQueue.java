/*
Задача 2. Класс OrderQueue
Создать класс - очередь, на обслуживание заявок клиентов в зависимости от величины суммы заказа.

2.1 Создать отдельный класс Order

2.2 Создать приватное свойство double sum  - сумма заказа

2.3 Создать приватное свойство int num  - номер заказа

2.4 Создать конструктор public Order(double sum) - для номера заказа создать систему автонумерации, начиная с 1

2.5 Создать геттер public double getSum()

2.6 Создать геттер public int getNum()

Создать класс OrderQueue

2.7 Создать метод, public void add(Order order), размещающий заказы в очередь с приоритетом, разбивая их по 3-м классам
3 - заказы до 10000 руб включительно
2 - заказы от 10000 до 20000 руб включительно
1 - заказы от 20000 руб

2.8 Создать метод, public Order get(), возвращающий первый заказ в очереди для обслуживания.
Вначале обслуживаются заказы класса 1, потом 2, потом 3.
Внутри каждого класса заказы должны обслуживаться в порядке поступления (по номеру заказа).
Метод не выбрасывает исключения, возвращает null в случае пустой очереди.

Продумать, и, при необходимости, добавить в классы нужные методы и свойства, для того, чтобы реализовать эту задачу.
 */

package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class OrderQueue {

    Comparator<Order> comparator = new Comparator<>() {
        @Override
        public int compare(Order o1, Order o2) {
            return Double.compare(o2.getSum(), o1.getSum());
        }
    };

    PriorityQueue<Order> queueByClass = new PriorityQueue<>(comparator);

    public void add(Order order) {
        if (order.getSum() > 0)
            queueByClass.offer(order);
    }

    public Order get() {
        Order order;
        if (!queueByClass.isEmpty()) {
            order = queueByClass.peek();
            queueByClass.remove(order);
            return order;
        }
        else return null;
    }


    public static void main(String[] args) {
        Random rnd = new Random();
        int[] intArray = new int[10];
        OrderQueue orderQueue = new OrderQueue();

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = rnd.nextInt();
            Order order = new Order(intArray[i]);
            order.setSum(3000 * i);
            orderQueue.add(order);
        }

        Iterator<Order> iterator = orderQueue.queueByClass.iterator();
        while (iterator.hasNext()) {
            Order forPrint = orderQueue.get();
            System.out.println(forPrint.getSum());
        }
    }
}
