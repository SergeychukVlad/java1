/*
Задача 2. Класс OrderQueue
Создать класс - очередь, на обслуживание заявок клиентов в зависимости от величины суммы заказа.

2.1 Создать отдельный класс Order

2.2 Создать приватное свойство double sum - сумма заказа

2.3 Создать приватное свойство int num - номер заказа

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

import java.util.*;

public class OrderQueue {

    ArrayDeque<Order> queueByClass1 = new ArrayDeque<>();   // Очередь 1-го класса
    ArrayDeque<Order> queueByClass2 = new ArrayDeque<>();   // Очередь 2-го класса
    ArrayDeque<Order> queueByClass3 = new ArrayDeque<>();   // Очередь 3-го класса

    public void add(Order order) {                          // Наполнение очередей по условиям классности

        double rate = order.getSum();

        if (rate > 0 && rate <= 10000) {
            queueByClass3.offer(order);
        } else if (rate > 10000 && rate <= 20000) {
            queueByClass2.offer(order);
        } else if (rate > 20000) {
            queueByClass1.offer(order);
        }

    }


    public Order get() {                                    // Выгрузка очередей последовательно, по классам

        List<ArrayDeque<Order>> queuesByClasses = Arrays.asList(queueByClass1, queueByClass2, queueByClass3);
        Order order;

        for (ArrayDeque<Order> queuesByClass : queuesByClasses) {
            if (!queuesByClass.isEmpty()) {
                order = queuesByClass.peek();
                queuesByClass.remove(order);
                return order;
            }
        }
        return null;

    }


    public static void myTest() {                               // Тестовые данные

        double[] intArrayValue = {
                21526.0, 10490.0, 22740.0, 25148.0, 23289.0, 29285.0, 18933.0, 21516.0, 21497.0, 16001.0,
                13195.0, 3392.0, 24899.0, 12092.0, 17080.0, 8262.0, 12832.0, 18173.0, 22135.0, 12656.0, 24332.0
        };
        OrderQueue orderQueue = new OrderQueue();

        System.out.println(" приём заявок - заполнение очередей ");
        for (int i = 0; i < 21; i++) {
            Order order = new Order(i);
            order.setSum(intArrayValue[i]);
            orderQueue.add(order);
            System.out.println(order.getSum() + " (" + order.getNum() + ")");
        }
        System.out.println(" выгрузка очередей по классности ");

        for (int i = 0; i < 21; i++) {
            Order order = orderQueue.get();
            System.out.println(order.getSum() + " (" + order.getNum() + ")");
        }

    }

    public static void main(String[] args) {
        myTest();
    }

}