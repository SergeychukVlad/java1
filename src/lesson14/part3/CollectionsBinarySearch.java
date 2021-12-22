package lesson14.part3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsBinarySearch {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("без", "труда", "не", "выловишь", "и", "рыбку", "из", "пруда");

//  быстрый двоичный поиск в ОТСОРТИРОВАННОМ списке
        list.sort(null);
        System.out.println(list);

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
[без, выловишь, и, из, не, пруда, рыбку, труда]
0
7
4
1
2
6
3
5
*/