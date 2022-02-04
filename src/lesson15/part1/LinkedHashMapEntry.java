package lesson15.part1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkedHashMapEntry {
    private static LinkedHashMap<String, String> getLinkedHashMap() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("ivanov1", "Иванов Иван Иванович");
        linkedHashMap.put("student1", "Студентов А.К.");
        linkedHashMap.put("UmnikRD", "Умников Раз Думович");
        linkedHashMap.put("tormoz_dk", "Тормозов Диск Колодович");
        linkedHashMap.put("student2", "Студентов А.К.");
        return linkedHashMap;
    }

    private static void getEntry(HashMap<String, String> linkedHashMap) {
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = getLinkedHashMap();
        getEntry(linkedHashMap);
    }
}
