package lesson15.part1;

import java.util.Hashtable;

public class HashTableVsNull {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        try {
            hashtable.put(null, "value");
        } catch (Throwable t) {
            System.out.println(t);
        }

        try {
            hashtable.put(1, null);
        } catch (Throwable t) {
            System.out.println(t);
        }
    }
}

/*
HashTable НЕ умеет работать с null !
Нельзя присвоить null ни ключу, ни значению.
 */
