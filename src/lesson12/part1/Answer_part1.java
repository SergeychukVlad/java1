package lesson12.part1;

import java.util.Collections;
import java.util.List;
/*
Ваш ответ верный.
1. Правильный ответ: Класс, реализующий полезные статические функции max, min, sort и др → Collections, Интерфейс для реализации списка → List, Интерфейс для реализации очереди → Queue, Класс, реализующий динамический массив → ArrayList, Интерфейс для реализации множества → Set, Интерфейс, для реализации хранилища объектов → Collection
2. Ваш ответ частично правильный.
Вы правильно выбрали 2.
Правильный ответ:

numbers.remove(3);

→ 0 1 2 4,

numbers.add(Collections.min(numbers));

→ 0 1 2 3 4 0,

numbers.add(3, 5);

→ Компилятор выдаст ошибку,

((ArrayList)numbers).add(3, numbers.size());

→ 0 1 2 5 3 4
 */
public class Answer_part1 {
    public List<Integer> listAction(List<Integer> list)
    {
        list.remove(Collections.min(list));
        list.add(0, list.size());
        list.add(2, Collections.max(list));
        return list;
    }

    public static void main(String[] args) {

    }
}
