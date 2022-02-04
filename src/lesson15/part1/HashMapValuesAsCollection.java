package lesson15.part1;

import java.util.*;

public class HashMapValuesAsCollection {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            hashMap.put(i, "строка" + i);
        }
        Collection<String> values = hashMap.values();

        System.out.println("foreach:");
        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("\niterator:");
        var iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
