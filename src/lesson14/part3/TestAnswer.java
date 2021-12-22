package lesson14.part3;

public class TestAnswer {
}
/*
1. Ваш ответ верный.Правильный ответ:
- Наполняет список list элементом obj → void fill(List<? super T> list, T obj),
- Копирует все элементы списка src  в список dest → void copy(Listt<? super T> dest, List<? extends T> src),
- Добавляет все elements в указанную коллекцию c → boolean addAll(Collection<? super T> c, T... elements),
- Возвращает immutable список из n элементов o → List nCopies(int n, T o)

2. Ваш ответ верный. Правильный ответ:
- Сортирует список list → void sort(List<T> list),
- Сортирует список list с использованием компаратора c → void sort(List<T> list, Comparator<? super T> c),
- Перетасовывает список list случайным образом → void shuffle(List<?> list),
- Возвращает компаратор, обратный заданному cmp → Comparator<T> reverseOrder(Comparator<T> cmp),
- Возвращает обратный компаратор → Comparator<T> reverseOrder(),
- Перетасовывает список list случайным образом на основе генератора ПСЧ rnd → void shuffle(List<?> list, Random rnd),
- Меняет порядок элементов в списке list на обратный → void reverse(List<?> list)

3. Ваш ответ верный. Правильный ответ:
- Возвращает true, если коллекции c1 и c2 не имеют одинаковых элементов → boolean disjoint(Collection<?> c1, Collection<?> c2),
- Ротация элементов списка list на distance элементов → void rotate(List<?> list, int distance),
- Возвращает количество вхождений объекта o в коллекцию c → int frequency(Collection<?> c, Object o),
- Рокировка элементов списка list с индексами i и j → void swap(List<?> list, int i, int j),
- Меняет в списке list все элементы oldVal на newVal → boolean replaceAll(List<T> list, T oldVal, T newVal)

4. Ваш ответ верный. Правильный ответ:
- Найти в списке source первое вхождение подсписка target → int indexOfSubList(List<?> source, List<?> target),
- Найти в списке source последнее вхождение подсписка target → int lastIndexOfSubList(List<?> source, List<?> target),
- Минимальный элемент коллекции coll → T min(Collection<? extends T> coll),
- Максимальный элемент коллекции coll → T max(Collection<? extends T> coll),
- Быстрый поиск в отсортированном списке list элемента key → int binarySearch(List<? extends Comparable<? super T>> list, T key)
 */
