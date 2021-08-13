package lesson12.part2;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static ArrayList creation() {
        List arrayList = new ArrayList<Integer>(10);
        arrayList.add(17);
        arrayList.add(22);
        arrayList.add(75);
        arrayList.add(175);
        arrayList.add(275);
        arrayList.add(375);
        arrayList.add(1, 109);
        System.out.println("отработал " + new Throwable().getStackTrace()[0].getMethodName() + "()\n" + arrayList);
        return (ArrayList) arrayList;
    }

    public static ArrayList action(ArrayList arrayList) {
        arrayList.remove(arrayList.size() - 1); // удалили последний элемент
        System.out.println("отработал " + new Throwable().getStackTrace()[0].getMethodName() + "()\n" + arrayList);
        return arrayList;
    }

    public static ArrayList specific(ArrayList arrayList) {
        arrayList.ensureCapacity(4); // уменьшили размер до 4 элементов
        System.out.println("отработал " + new Throwable().getStackTrace()[0].getMethodName() + "() and ensureCapacity\n" + arrayList);
        arrayList.trimToSize(); // сжать массив до реального кол-ва элементов в нём
        System.out.println("отработал " + new Throwable().getStackTrace()[0].getMethodName() + "() and trimToSize\n" + arrayList);
        return arrayList;
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
