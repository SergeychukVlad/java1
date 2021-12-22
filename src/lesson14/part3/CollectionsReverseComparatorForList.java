package lesson14.part3;

import java.util.*;

public class CollectionsReverseComparatorForList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 3, 2, 1, 5, 6, 8);
        System.out.println(list);
//  сортировка с компаратором
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
