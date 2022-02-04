package lesson15.part1;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashMapContains {
    static int ELEMENT_COUNT = 500_000;

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < ELEMENT_COUNT; i++)
            hashMap.put(i, i);

        long start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i += 500)
            hashMap.containsValue(i);
        System.out.println("hashMap.containsValue: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < ELEMENT_COUNT; i += 500)
            hashMap.containsKey(i);
        System.out.println("hashMap.containsKey: " + (System.currentTimeMillis() - start));
    }
}
