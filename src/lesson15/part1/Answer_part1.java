/*
5. Реализуйте метод с сигнатурой HashMap<Integer, String> a2map(int[] akey, String[] aval),
который создает Map на основе пары массивов akey (ключи) и aval (значения).
Первому элементу массива akey соответствует первый элемент массива aval, и т.д.
Размеры массивов одинаковые.
 */
package lesson15.part1;

import java.util.HashMap;

public class Answer_part1 {

    HashMap<Integer, String> a2map(int[] akey, String[] aval) {

        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < akey.length; i++) {
            hashMap.put(akey[i], aval[i]);
        }
        return hashMap;
    }

    public static void main(String[] args) {

    }
}

/*
1. Ваш ответ верный. Правильные ответы:
Словари предназначены для быстрого поиска по ключу,
Элементом словаря является пара ключ-значение (Map.Entry),
Ключи уникальны, значения могут повторяться

2. Ваш ответ верный. Правильный ответ:
Найти и вернуть значение по ключу → V get(Object key),
Удалить Entry по ключу → V remove(Object key),
Очистить словарь → void clear(),
Добавить пару ключ-значение (Entry) → V put(K key, V value)

3. Ваш ответ верный. Правильный ответ:
Словарь пустой? → boolean isEmpty(),
Размер словаря (количество Entry) → int size(),
Есть ли такой ключ? → boolean containsKey(Object key),
Есть ли такое значение? → boolean containsValue(Object value)

4. Ваш ответ верный. Правильный ответ:
Добавить все элементы из map m → void putAll(Map<? extends K,? extends V> m),
Множество ключей → Set<K&gt keySet(),
Коллекция значений → Collection<V> values(),
Множество элементов (Entry) → Set<Map.Entry<K,V>> entrySet()




*/
