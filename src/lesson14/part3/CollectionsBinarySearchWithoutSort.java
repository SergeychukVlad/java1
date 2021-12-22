package lesson14.part3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsBinarySearchWithoutSort {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("без", "труда", "не", "выловишь", "и", "рыбку", "из", "пруда");
        System.out.println(list);

//  быстрый двоичный поиск в списке
        System.out.println(Collections.binarySearch(list, "без"));
        System.out.println(Collections.binarySearch(list, "труда"));
        System.out.println(Collections.binarySearch(list, "не"));
        System.out.println(Collections.binarySearch(list, "выловишь"));
        System.out.println(Collections.binarySearch(list, "и"));
        System.out.println(Collections.binarySearch(list, "рыбку"));
        System.out.println(Collections.binarySearch(list, "из"));
        System.out.println(Collections.binarySearch(list, "пруда"));
    }
}
/*
[без, труда, не, выловишь, и, рыбку, из, пруда]
        0
        -9
        -6
        3
        4
        5
        -6
        -6

BinarySearch() корректно работает только с отсортированным списком
*/