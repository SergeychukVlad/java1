package lesson15.part1;

import java.util.HashMap;
import java.util.Map;

public class HashMapSimple {
    private static HashMap<String, String> getHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("ivanov1", "Иванов Иван Иванович");
        hashMap.put("student1", "Студентов А.К.");
        hashMap.put("UmnikRD", "Умников Раз Думович");
        hashMap.put("tormoz_dk", "Тормозов Диск Колодович");
        hashMap.put("student2", "Студентов А.К.");
        return hashMap;
    }

    private static void getEntry(HashMap<String, String> hashMap) {
        System.out.println(new Object() {
        }
                .getClass()
                .getEnclosingMethod()
                .getName());
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void getKey(HashMap<String, String> hashMap) {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName());
        String[] keys = {"student1", "UmnikRD", "student2"};
        for (String key : keys) {
            System.out.println("По ключу " + key + " найдено значение " + hashMap.get(key));
        }
    }

    private static void editHashMap(HashMap<String, String> hashMap, String key, String newValue) {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("По ключу " + key + " изменено значение " + hashMap.put(key, newValue));
    }

    private static void removeHashMap(HashMap<String, String> hashMap, String key) {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("По ключу " + key + " удалена Entry");
        hashMap.remove(key);
        getEntry(hashMap);
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = getHashMap();
        getKey(hashMap);
        getEntry(hashMap);

        editHashMap(hashMap, "student2", "Студентов Семестр Зачетович");
        removeHashMap(hashMap, "UmnikRD");
    }
}
