package lesson12.part1;

import java.util.ArrayList;

/*
Объявление с типизацией
 */
public class ArrayListDeclaration2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();

        arrayList.add(1);       // автоупаковка
        // все остальные строки - ошибки
//        arrayList.add(1.0);     // автоупаковка
//        arrayList.add(true);    // автоупаковка
//        arrayList.add(new Object());
//        arrayList.add(new ArrayList());
    }
}
