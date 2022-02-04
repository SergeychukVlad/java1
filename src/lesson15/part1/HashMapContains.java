package lesson15.part1;

import java.util.HashMap;
import java.util.Map;

public class HashMapContains {
    private static HashMap<String, String> getHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("ivanov1", "Иванов Иван Иванович");
        hashMap.put("student1", "Студентов А.К.");
        hashMap.put("UmnikRD", "Умников Раз Думович");
        hashMap.put("tormoz_dk", "Тормозов Диск Колодович");
        hashMap.put("student2", "Студентов А.К.");
        return hashMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = getHashMap();
        System.out.println(hashMap.containsKey("student1"));
        System.out.println(hashMap.containsKey("student2"));
        System.out.println(hashMap.containsKey("student3"));
        System.out.println(hashMap.containsKey(null));
        System.out.println(hashMap.containsValue("Студентов А.К."));
        System.out.println(hashMap.containsValue("Студентов А.E."));
        System.out.println(hashMap.containsValue(null));
        System.out.println(hashMap.containsValue("Тормозов Диск Колодович"));
    }
}
