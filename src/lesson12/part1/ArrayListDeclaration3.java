package lesson12.part1;
/*
Варианты объявления ArrayList
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayListDeclaration3 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList();

        // и через интерфейс...
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList();
    }
}
