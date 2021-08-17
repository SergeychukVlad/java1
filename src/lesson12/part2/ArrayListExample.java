package lesson12.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {

    public static ArrayList creation() {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " работает... ");
        List<Integer> arrayList = new ArrayList(Arrays.asList(17, 22, 75, 175, 275, 375));
        System.out.println(arrayList + "\n");
        return (ArrayList) arrayList;
    }

    public static ArrayList action(ArrayList arrayList) {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " работает... ");
        arrayList.add(1, 109); // добавил элемент по индексу
        arrayList.remove(arrayList.size() - 1); // удалили последний элемент
        System.out.println(arrayList + "\n");
        return arrayList;
    }

    public static void specific(ArrayList arrayList) {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " работает... ");

        arrayList.removeIf(i -> (i.equals(109) || i.equals(275))); // удалили элементы 109, 275
        System.out.println("удалили элементы со значениями 109, 275 - removeIf: " + arrayList);
        arrayList.ensureCapacity(14);
        System.out.println("увеличили ёмкость резервного массива до 14 элементов - ensureCapacity: " + arrayList);
        arrayList.addAll(Arrays.asList(null, null));
        System.out.println("добавили пару NULL - addAll: " + arrayList);
        arrayList.trimToSize();
        System.out.println("сжать массив до реального кол-ва элементов в нём - trimToSize: " + arrayList);
    }

    public static void main(String[] args) {
        /*
        выводы по скорости ArrayList:
        -add в конец списка - быстро!
        -add в начало списка - медленно()
        -remove последнего элемента - быстро!
        -remove первого - медленно()
        -обращение к любому элементу - быстро!
         */

        specific(action(creation()));
    }

}
