package lesson15.part1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapCollections {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            hashMap.put(i, "строка" + i);
        }
        System.out.println(hashMap);

        Set<Integer> keys = hashMap.keySet();
        Collection<String> values = hashMap.values();
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();

        System.out.println(keys);
        System.out.println(values);
        System.out.println(entries);
    }
}
