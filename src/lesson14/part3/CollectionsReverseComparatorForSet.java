package lesson14.part3;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsReverseComparatorForSet {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>(List.of(1, 2, 6, 9, 0));
        System.out.println(set);

//  использование обратного компаратора
        Set<Integer> setReverse = new TreeSet<>(Collections.reverseOrder());
        Collections.addAll(setReverse, 2, 1, 9, 7, 6, 0);
        System.out.println(setReverse);
    }
}
