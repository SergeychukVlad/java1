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


    PriorityQueue<Order> queueByClass1 = new PriorityQueue<>(comparator);
    PriorityQueue<Order> queueByClass2 = new PriorityQueue<>(comparator);
    PriorityQueue<Order> queueByClass3 = new PriorityQueue<>(comparator);

    int currentServiceClass = 1;

    public void add(Order order) {
        queueByClass.offer(order);

        double rate = order.getSum();
        if (rate > 0 && rate <= 10000) {
            queueByClass1.offer(order);
        }
        else if (rate > 10000 && rate <= 20000) {
            queueByClass2.offer(order);
        }
        else if (rate > 20000) {
            queueByClass1.offer(order);
        }
    }

    public Order get() {
        Order order;
        if (!queueByClass1.isEmpty() && currentServiceClass == 1) {
            order = queueByClass1.peek();
            queueByClass1.remove(order);
            currentServiceClass++;
            return order;
        } else if (!queueByClass2.isEmpty() && currentServiceClass == 2) {
            order = queueByClass2.peek();
            queueByClass2.remove(order);
            currentServiceClass++;
            return order;
        } else if (!queueByClass3.isEmpty() && currentServiceClass == 3) {
            order = queueByClass3.peek();
            queueByClass3.remove(order);
            currentServiceClass = 1;
            return order;
        } else return null;
    }

    public int getCurrentClass() {
        return 0;
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
            System.out.println(order.getSum() + " (" + order.getNum() + ")");
        }

    }
}

/*
Задача 2. Класс OrderQueue: не пройдено, оценка: 0.0
Комментарий:
ERROR: Тест "Метод get()" не пройден. Метод работает неверно.
Последовательно был вызван метод add с параметрами типа Order, имеющими значения sum, равные:
21526.0, 10490.0, 22740.0, 25148.0, 23289.0, 29285.0, 18933.0, 21516.0, 21497.0, 16001.0, 13195.0, 3392.0, 24899.0,
12092.0, 17080.0, 8262.0, 12832.0, 18173.0, 22135.0, 12656.0, 24332.0.

После этого возвраты метода get в формате sum(num) до значения null оказались:
29285.0(5), 25148.0(3), 24899.0(12), 24332.0(20), 23289.0(4), 22740.0(2), 22135.0(18), 21526.0(0), 21516.0(7),
21497.0(8), 18933.0(6), 18173.0(17), 17080.0(14), 16001.0(9), 13195.0(10), 12832.0(16), 12656.0(19), 12092.0(13),
10490.0(1), 8262.0(15), 3392.0(11).

Ожидалось:
21526.0(1), 22740.0(3), 25148.0(4), 23289.0(5), 29285.0(6), 21516.0(8), 21497.0(9), 24899.0(13), 22135.0(19),
24332.0(21), 10490.0(2), 18933.0(7), 16001.0(10), 13195.0(11), 12092.0(14), 17080.0(15), 12832.0(17), 18173.0(18),
12656.0(20), 3392.0(12), 8262.0(16).

По данной задаче в целом не зачет, решение возвращено на доработку. Задача выполнена на 0.00%
 */