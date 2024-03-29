package lesson14.part3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsIndexOfSublistMaxMin {
    public static void main(String[] args) {
        String text = "Если приглашая Даму на танец, вы наступили ей на ногу, " +
                "и она сделала вид, что не заметила этого, " +
                "как она заметила, но сделала вид, что не заметила.";
//  убираем точки и запятые
        text = text.replaceAll("[.,]", "").toLowerCase();
//  массив слов в список
        List<String> list = Arrays.asList(text.split(" "));
//  сколько раз в списке встречается элемент
        List<String> subList = Arrays.asList("не", "заметила");

        System.out.println(Collections.indexOfSubList(list, subList));
        System.out.println(Collections.lastIndexOfSubList(list, subList));
        System.out.println(Collections.indexOfSubList(list, Arrays.asList("1")));

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
    }
}
/*
15
25
-1
этого
вид

если не найден элемент, то вернётся -1
 */
