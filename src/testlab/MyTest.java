package testlab;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyTest {
    public static void main(String[] args) {
//        test1();
//        test2();
        test4();
    }

    private static void test1() {
        Set<Integer> test = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Set<Integer> integers1 = Set.of(7, 8, 9);
        Set<Integer> integers2 = Set.of(1, 4, 7);

        Set<Integer> result = new HashSet<>(test);
        result.retainAll(integers1);
        result.retainAll(integers2);
        System.out.println(result);
    }

    private static void test2() {
        Set<Integer> integers1 = Set.of(2, 3, 5, 7, 8);
        Set<Integer> integers2 = Set.of(3, 5, 8, 10);
        Set<Integer> integers3 = Set.of(1, 4, 6, 7, 10);

        Set<Integer> result = new HashSet<>();
        result.addAll(integers1);
        result.addAll(integers2);
        result.addAll(integers3);
        System.out.println(result);
    }

    private static void test3() {
        Set<Integer> integers1 = Set.of(1, 2, 4, 5);
        Set<Integer> integers2 = Set.of(4, 7, 8, 9);
        Set<Integer> integers3 = Set.of(1, 2, 4, 5, 9);

        Set<Integer> result = new HashSet<>();
        result.addAll(integers1);
        result.addAll(integers2);
        result.addAll(integers3);
        System.out.println(result);

        Set<Integer> intersection = new HashSet<>(integers1);
        intersection.retainAll(integers2);

        result.removeAll(intersection);
        System.out.println(result);

        result.removeAll(integers3);
        System.out.println(result);
    }

    private static void test4() {
        Set<Integer> test = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Set<Integer> integers1 = Set.of(1, 2, 3, 8);
        Set<Integer> integers2 = Set.of(3, 6, 9, 10);
        Set<Integer> integers3 = Set.of(3, 7, 8, 10);

        Set<Integer> sum = new HashSet<>(integers1);
        sum.addAll(integers2);
        sum.addAll(integers3);
        System.out.println(sum);

        Set<Integer> intersection = new HashSet<>();
        intersection.addAll(integers1);
        intersection.addAll(integers2);

        intersection.retainAll(integers3);
        sum.removeAll(intersection);
        intersection.clear();
        System.out.println(sum);
    }
}
