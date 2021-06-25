package lesson11.part3.stringbuilder;

import java.util.Arrays;

/*
Преобразуем строку в массив
 */
public class StringSplit {
    public static void main(String[] args) {
        final String regNums = "Word0, Word1, Word2, Word3, Word4, Word5";
        final String[] regNumArray = regNums.split(",");
        System.out.println("Длина массива: " + regNumArray.length);
        System.out.println(Arrays.toString(regNumArray));
    }
}
