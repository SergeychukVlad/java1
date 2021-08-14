/*
1. Ваш ответ верный.
Правильные ответы:
Добавление в конец списка,
Удаление последнего элемента,
Обращение к любому элементу

2. Ваш ответ верный.
Правильные ответы:
Доступ в конец или начало,
Добавление в начало или конец,
Удаление из начала или конца

3. Ваш ответ верный.
Правильный ответ:
ArrayList организован на основе → массива,
LinkedList организован на основе  → двунаправленного списка

4. Напишите метод, с сигнатурой public List<Integer> filter(List<Integer> list) который работает по следующему алгоритму
- суммирует значения всех элементов списка
- удаляет из списка элементы, значение которых больше суммы, деленной на 100 (целочисленное деление)
- возвращает результирующий список
 */
package lesson12.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer_part3 {

    public static List<Integer> filter(List<Integer> list) {
        Integer sum = 0;
        ArrayList<Integer> myList = new ArrayList();

        for (Integer integer : list) {
            sum += integer;
        }

        for (int i = 0; i <= list.size() - 1; i++) {
            Integer integer = list.get(i);
            if (integer <= (sum / 100)) {
                myList.add(integer);
            }
        }

        return myList;
    }

    public static void main(String[] args) {
        System.out.println(filter(Arrays.asList(-5, 1, 3, 10, -10, 2, 9, 8, 7, 134, 55, 220, 0)));
    }

}
