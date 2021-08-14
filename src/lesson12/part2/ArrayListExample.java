package lesson12.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {

    public static ArrayList creation() {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName() + "работает... ");
        List<Integer> arrayList = new ArrayList(Arrays.asList(17, 22, 75, 175, 275, 375));
        System.out.println(arrayList);
        return (ArrayList) arrayList;
    }

    public static ArrayList action(ArrayList arrayList) {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName() + "()\n" + arrayList + "работает... ");
        arrayList.add(1, 109); // добавил элемент по индексу
        arrayList.remove(arrayList.size() - 1); // удалили последний элемент
        return arrayList;
    }

    public static void specific(ArrayList arrayList) {
        System.out.println(new Throwable().getStackTrace()[0].getMethodName() + "работает... ");
        arrayList.ensureCapacity(4);
        System.out.println("уменьшили размер до 4 элементов - ensureCapacity: " + arrayList);
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
