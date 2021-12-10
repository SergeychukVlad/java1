package testlab;

import java.util.HashSet;
import java.util.Set;

public class MyTest {
    public static void main(String[] args) {

        Set<Integer> integers1 = Set.of(1, 2, 4, 5);
        Set<Integer> integers2 = Set.of(4, 7, 8, 9);
        Set<Integer> integers3 = Set.of(1, 2, 4, 5, 9);

        Set<Integer> result = new HashSet<>();
        result.addAll(integers1);
        result.addAll(integers2);
        result.addAll(integers3);
        System.out.println(result);

        Set<Integer> intersection = new HashSet<>();
        intersection.addAll(integers1);
        intersection.retainAll(integers2);

        result.removeAll(intersection);
        System.out.println(result);

        result.removeAll(integers3);
        System.out.println(result);

    }
}
