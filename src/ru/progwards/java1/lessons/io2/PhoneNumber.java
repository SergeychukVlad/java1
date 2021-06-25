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

public class PhoneNumber {
    public static String format(String phone) {
        return null;
    }

    public static void main(String[] args) {
        format("79991112233");
        format("8(999)111-22-33");
        format("8 999 111 22 33");
    }
}
