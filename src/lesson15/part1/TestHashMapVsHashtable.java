package lesson15.part1;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashMapVsHashtable {
    static int ELEMENT_COUNT = 500_000;

    public static void main(String[] args) {
        HashMap<Integer, String > hashMap = new HashMap<>();
        Hashtable<Integer, String > hashtable = new Hashtable<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++)
            hashMap.put(i, "строка" + i);
        System.out.println("Добавление в hashMap " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++)
            hashtable.put(i, "строка" + i);
        System.out.println("Добавление в hashtable " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++)
            hashMap.get(i);
        System.out.println("Поиск в hashMap " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i++)
            hashtable.get(i);
        System.out.println("Поиск в hashtable " + (System.currentTimeMillis() - start));

        Integer keyTmp;
        String valTmp;

        start = System.currentTimeMillis();
        for (var key : hashMap.keySet())
            keyTmp = key;
        System.out.println("Итератор по ключу в hashMap " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (var entry : hashMap.values())
            valTmp = entry;
        System.out.println("Итератор по значению в hashMap " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (var key : hashtable.keySet())
            keyTmp = key;
        System.out.println("Итератор по ключу в hashtable " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (var entry : hashtable.values())
            valTmp = entry;
        System.out.println("Итератор по значению в hashtable " + (System.currentTimeMillis() - start));
    }
}
