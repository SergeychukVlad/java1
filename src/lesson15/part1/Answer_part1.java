/*
Реализуйте метод с сигнатурой HashMap<Integer, String> a2map(int[] akey, String[] aval),
который создает Map на основе пары массивов akey (ключи) и aval (значения).
Первому элементу массива akey соответствует первый элемент массива aval, и т.д.
Размеры массивов одинаковые.
 */
package lesson15.part1;

import java.util.HashMap;

public class Answer_part1 {

    HashMap<Integer, String> a2map(int[] akey, String[] aval) {

        HashMap<Integer, String> hashMap = new HashMap<>();

        for (int i = 0; i < akey.length; i++) {
            hashMap.put(akey[i], aval[i]);
        }
        return hashMap;
    }

    public static void main(String[] args) {

    }
}
