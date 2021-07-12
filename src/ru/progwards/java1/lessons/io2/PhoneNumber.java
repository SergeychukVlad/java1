/*
Класс PhoneNumber.
Создать статический метод public static String format(String phone), который форматирует телефон
под формат +7(999)111-2233, входящий формат может быть различным:
- 79991112233
- 8(999)111-22-33
- 8 999 111 22 33

формальное задание на форматирование:
- выделить все цифры, отбросить все разделители
- проверить что цифр в номере 11 или 10, в противном случае выбросить исключение
- убрать спереди 8
- добавить, если нужно +7
- отформатировать под выходной шаблон
 */
package ru.progwards.java1.lessons.io2;

import java.util.Scanner;

public class PhoneNumber {
    public static String getResultPhoneNumber(String phoneNumber) {
        if (phoneNumber.charAt(0) == '7' || phoneNumber.charAt(0) == '8') {
            phoneNumber = "+7(" + phoneNumber.substring(1, 4) + ")"
                    + phoneNumber.substring(4, 7) + "-" + phoneNumber.substring(7);
        }
        return phoneNumber;
    }

    public static String format(String phone) {
        StringBuilder sourcePhoneNumber = new StringBuilder();
        try (Scanner scanner = new Scanner(phone).useDelimiter("\\s*,\\s*")) {
            while (scanner.hasNextLine()) {
                char[] chars = scanner.next().toCharArray();
                for (char aChar : chars) {
                    if (Character.isDigit(aChar)) {
                        sourcePhoneNumber.append(aChar);
                    }
                }

                if ((sourcePhoneNumber.length() < 10) || (sourcePhoneNumber.length() > 11)) {
                    throw new Exception();
                } else {
                    phone = getResultPhoneNumber(sourcePhoneNumber.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("В исходном телефонном номере неверное количество цифр: требуется 10 или 11, а имеем "
                    + sourcePhoneNumber.length());
        }
        return phone;
    }

    public static void main(String[] args) {
        format("7999111223345");
        format("8 479 713 58 16");
        format("79991112233");
        format("8(999)111-22-33");
        format("8 999 111 22 33");
    }
}
