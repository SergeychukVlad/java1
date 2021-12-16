package lesson14.part2;

import java.util.ArrayDeque;

public class TestAnswer {
    /*
1. Отметьте верные утверждения, касающиеся Deque (Выберите один или несколько ответов):
a. ArrayDeque позволяет избежать копирования массивов при добавлении и удалении +
b. Двусторонняя очередь работает по принципу LIFO - Last In First Out           +
c. Двусторонняя очередь не содержит методы выбрасывающие исключения
d. Двусторонняя очередь не содержит методы не выбрасывающие исключения
e. Двусторонняя очередь работает по принципу FIFO - First In First Out          +


2. Поставьте соответствие названию методу его назначение

Перетасовывает список list случайным образом на основе генератора ПСЧ rnd       void shuffle(List<?> list, Random rnd)
Сортирует список list с использованием компаратора c                            void sort(List<T> list, Comparator<? super T> c)
Возвращает обратный компаратор                                                  Comparator<T> reverseOrder()
Перетасовывает список list случайным образом                                    void shuffle(List<?> list)
Возвращает компаратор, обратный заданному cmp                                   Comparator<T> reverseOrder(Comparator<T> cmp)
Меняет порядок элементов в списке list на обратный                              void reverse(List<?> list)
Сортирует список list                                                           void sort(List<T> list)
     */
    static int sumLastAndFirst(ArrayDeque<Integer> deque) {
        if (!deque.isEmpty()) {
            return deque.getFirst() + deque.getLast();
        } else return 0;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addFirst(30);
        deque.addFirst(50);
        System.out.println(deque);
        System.out.println(sumLastAndFirst(deque));
    }
}
