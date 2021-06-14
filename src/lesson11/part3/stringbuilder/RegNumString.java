/*
Нормализация регистрационного номера авто (версия 2)
 */
package lesson11.part3.stringbuilder;

import java.util.Arrays;

public class RegNumString {
    private String regNum = "";

    public RegNumString(String str) {
        // 1 concatenation
        concatenationWithPlus(str);

        // 2 stringBuilder
        concatenationWithStringBuilder(str);
    }

    void concatenationWithPlus(String str) {
        for (char c : str.toCharArray())
            if (Character.isDigit(c) || Character.isAlphabetic(c))
                regNum += Character.toUpperCase(c);
    }

    void concatenationWithStringBuilder(String str) {
        StringBuilder stringBuilder = new StringBuilder(10);
        for (char c : str.toCharArray())
            if (Character.isDigit(c) || Character.isAlphabetic(c))
                stringBuilder.append(Character.toUpperCase(c));
        regNum = stringBuilder.toString();
    }

    @Override
    public String toString() {
        return regNum;
    }

    public static void main(String[] args) {
        String[] regNumArr = {"а 123 аК 177", "а 027 УН   270  ", " е  565 ЕЕ 138", "№ в987ФФ 077", "У666еЕ ### 55   "};
        final RegNumString[] regNums = new RegNumString[regNumArr.length];
        for (int i = 0; i < regNums.length; i++) {
            // преобразуем строку в регистрационный номер
            regNums[i] = new RegNumString(regNumArr[i]);
        }
        System.out.println(Arrays.toString(regNums));
    }
}
