package lesson15.part1;

import java.util.Collection;
import java.util.HashMap;

public class HashMapValuesAsCollectionRemove {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            hashMap.put(i, "строка" + i);
        }
        System.out.println(hashMap);

        Collection<String> values = hashMap.values();

        values.remove("строка2");
        values.remove("строка4");
        System.out.println("values after remove = " + values);
        System.out.println("hashMap after remove = " + hashMap);

        values.clear();
        System.out.println("values after clear = " + values);
        System.out.println("hashMap after clear = " + hashMap);
    }
}
