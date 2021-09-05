/*
HashSet для отбора УНИКАЛЬНЫХ слов (элементов)
 */
package lesson13.part1;

import java.util.*;

public class NaDvoreTrava {
    final static String TEXT = "на дворе трава на траве дрова Не руби дрова на траве двора";

    public static void main(String[] args) {
        String[] words = TEXT.split(" ");
        List<String> wordList = Arrays.asList(words); // Если хотим List (фиксированная длина массива)
        List<String> wordArrayList = new ArrayList<>(Arrays.asList(words));
        // Если хотим ArrayList (c возможностью добавить/удалить)
        Set<String> wordSet = new HashSet<>(wordList);
        System.out.println("wordList: " + wordList);
        System.out.println("wordArrayList: " + wordArrayList);
        System.out.println("wordSet: " + wordSet);
    }
}
