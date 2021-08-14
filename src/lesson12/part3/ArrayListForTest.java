/*
Тестирование for / forEach для ArrayList
 */

package lesson12.part3;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ArrayListForTest {
    static final int ELEMENT_COUNT = 50_000;

    public static void arrayListOperationTest() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        List<Integer> arrayList = new ArrayList();
        var startTime = new Date().getTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(i);
        }
        System.out.println("Добавление: " + (new Date().getTime() - startTime));

        int result = 0;
        startTime = new Date().getTime();
        for (Integer i : arrayList) {
            result += i;
        }
        System.out.println("For each: " + (new Date().getTime() - startTime));

        result = 0;
        startTime = new Date().getTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            result += arrayList.get(i);
        }
        System.out.println("For: " + (new Date().getTime() - startTime));
    }

    public static void linkedListOperationTest() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        List<Integer> arrayList = new LinkedList();
        var startTime = new Date().getTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(i);
        }
        System.out.println("Добавление: " + (new Date().getTime() - startTime));

        int result = 0;
        startTime = new Date().getTime();
        for (Integer i : arrayList) {
            result += i;
        }
        System.out.println("For each: " + (new Date().getTime() - startTime));

        result = 0;
        startTime = new Date().getTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            result += arrayList.get(i);
        }
        System.out.println("For: " + (new Date().getTime() - startTime));
    }

    public static void listAddInStartTest() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        var startTime = new Date().getTime();
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(0, i);
        }
        System.out.println("Добавление в начало ArrayList: " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            linkedList.add(0, i);
        }
        System.out.println("Добавление в начало LinkedList: " + (new Date().getTime() - startTime));
    }

    public static void listAddInCenterTest() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        var startTime = new Date().getTime();
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        System.out.println("Добавление в середину ArrayList: " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            linkedList.add(linkedList.size() / 2, i);
        }
        System.out.println("Добавление в середину LinkedList: " + (new Date().getTime() - startTime));
    }

    public static void listsRemoveFromEnd() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        List<Integer> arrayList = new ArrayList();
        List<Integer> linkedList = new LinkedList();

        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        var startTime = new Date().getTime();
        for (int i = ELEMENT_COUNT - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        System.out.println("Удаление с конца ArrayList: " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        for (int i = ELEMENT_COUNT - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        System.out.println("Удаление с конца LinkedList: " + (new Date().getTime() - startTime));
    }

    public static void listsRemoveFromStart() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        List<Integer> arrayList = new ArrayList();
        List<Integer> linkedList = new LinkedList();

        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        var startTime = new Date().getTime();
        for (int i = ELEMENT_COUNT - 1; i >= 0; i--) {
            arrayList.remove(0);
        }
        System.out.println("Удаление из начала ArrayList: " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        for (int i = ELEMENT_COUNT - 1; i >= 0; i--) {
            linkedList.remove(0);
        }
        System.out.println("Удаление из начала LinkedList: " + (new Date().getTime() - startTime));
    }

    public static void listsRemoveFromCenter() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        List<Integer> arrayList = new ArrayList();
        List<Integer> linkedList = new LinkedList();

        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        var startTime = new Date().getTime();
        for (int i = ELEMENT_COUNT - 1; i >= 0; i--) {
            arrayList.remove(arrayList.size() / 2);
        }
        System.out.println("Удаление из середины ArrayList: " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        for (int i = ELEMENT_COUNT - 1; i >= 0; i--) {
            linkedList.remove(linkedList.size() / 2);
        }
        System.out.println("Удаление из середины LinkedList: " + (new Date().getTime() - startTime));
    }

    public static void listsSetInFirstAndEnd() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("если 25 тыс записей - то скорость ArrayList лучше в 2 раза");
        System.out.println("если 1 млн записей - то скорость одинакова");
        System.out.println("если 25 млн записей - то скорость LinkedList лучше в 4 раза");
    }

    public static void listsSetInCenter() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());

        List<Integer> arrayList = new ArrayList();
        List<Integer> linkedList = new LinkedList();

        for (int i = 0; i < ELEMENT_COUNT; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        var startTime = new Date().getTime();
        for (int i = ELEMENT_COUNT - 1; i >= 0; i--) {
            arrayList.set(ELEMENT_COUNT / 2, i);
        }
        System.out.println("Set в середине ArrayList: " + (new Date().getTime() - startTime));

        startTime = new Date().getTime();
        for (int i = ELEMENT_COUNT - 1; i >= 0; i--) {
            linkedList.set(ELEMENT_COUNT/2, i);
        }
        System.out.println("Set в середине LinkedList: " + (new Date().getTime() - startTime));
    }


    public static void resume() {
        System.out.println("результат на " + new Throwable().getStackTrace()[0].getMethodName());
        System.out.println("В качестве списка лучше - ArrayList");
        System.out.println("LinkedList хорош там, где основные операции: добавление/удаление в начале списка");
        System.out.println("LinkedList хорош в качестве стека");
        System.out.print("если LinkedList, то следует избегать вызовов методов, связанных с доступом по индексу ");
        System.out.println("в середину списка: add/get/set/remove");
    }

    public static void main(String[] args) {
        System.out.println("Количество записей - " + ELEMENT_COUNT + "\n");
        arrayListOperationTest();
        System.out.println();
        linkedListOperationTest();
        System.out.println();
        listAddInStartTest();
        System.out.println();
        listAddInCenterTest();
        System.out.println();
        listsRemoveFromEnd();
        System.out.println();
        listsRemoveFromStart();
        System.out.println();
        listsRemoveFromCenter();
        System.out.println();
        listsSetInFirstAndEnd();
        System.out.println();
        listsSetInCenter();
        System.out.println();
        resume();
    }
}
