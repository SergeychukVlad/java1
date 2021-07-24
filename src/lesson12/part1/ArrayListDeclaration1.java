package lesson12.part1;

import java.util.ArrayList;
/*
Объявление без указания типа объекта
 */
public class ArrayListDeclaration1 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        arrayList.add(1);       // автоупаковка
        arrayList.add(1.0);     // автоупаковка
        arrayList.add(true);    // автоупаковка
        arrayList.add(new Object());
        arrayList.add(new ArrayList());
    }
}
