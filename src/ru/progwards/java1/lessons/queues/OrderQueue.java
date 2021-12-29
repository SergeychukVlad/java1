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

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class OrderQueue {
    PriorityQueue<Order> queueByClass1 = new PriorityQueue<>();
    PriorityQueue<Order> queueByClass2 = new PriorityQueue<>();
    PriorityQueue<Order> queueByClass3 = new PriorityQueue<>();

    public void add(Order order) {
        if (order.getSum() > 0 && order.getSum() <= 10000) {
            queueByClass3.add(order);
        } else if (order.getSum() > 10000 && order.getSum() <= 20000) {
            queueByClass2.offer(order);
        } else if (order.getSum() > 20000) {
            queueByClass1.offer(order);
        }
    }

    public Order get() {
        List<PriorityQueue<Order>> queues = List.of(this.queueByClass1, queueByClass2, queueByClass3);
        Order order = null;
        if (queues.isEmpty()) {
            return order;
        } else {
            for (int i = 0; i < queues.size(); i++) {
                order =  queues.get(i).peek();
            }
        }
        return order;
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
            System.out.print(order.getNum());
            System.out.println(" " + order.getSum());
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(orderQueue.get());
        }
    }

}
