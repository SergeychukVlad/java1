/*
Нормализация регистрационного номера авто (версия 1)
 */
package lesson11.part3.stringbuilder;

import java.util.Arrays;

public class NormalizeRegNums {

    public static void clearingString1(String[] regNumArr) {
        for (int i = 0; i < regNumArr.length; i++) {
            regNumArr[i] = regNumArr[i].replace(" ", "");   // убираем пробелы
            regNumArr[i] = regNumArr[i].replace("№", "");   // убираем (№)
            regNumArr[i] = regNumArr[i].toUpperCase();                      // переводим в верхний регистр
        }
        System.out.println(Arrays.toString(regNumArr));
    }

    public static void main(String[] args) {
        String[] regNumArr = {"а 123 аК 177", "а 027 УН   270  ", " е  565 ЕЕ 138", "№ в987ФФ 077", "У666еЕ ### 55   "};
        clearingString1(regNumArr);
    }
}
