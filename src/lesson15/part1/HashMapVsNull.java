package lesson15.part1;

import java.util.HashMap;
import java.util.Map;

public class HashMapVsNull {

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
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void nullToHashMap(HashMap<String, String> hashMap, String key) {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("По ключу " + key + " изменено значение на null ");
        hashMap.put(key, null);
        System.out.println("кладём ключ null и значение null ");
        hashMap.put(null, null);
        getEntry(hashMap);
    }

    public static void main(String[] args) {
        nullToHashMap(getHashMap(), "student2");
    }

}

/*
HashMap умеет работать с null !
 */
