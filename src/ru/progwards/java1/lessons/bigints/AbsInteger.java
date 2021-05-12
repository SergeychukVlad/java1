/*
Класс AbsInteger и потомки

2.1 Реализовать класс AbsInteger - абстрактное целое число
2.2 Реализовать потомков ByteInteger, ShortInteger, IntInteger, хранящих значение целого числа соответствующего типа.
У каждого типа реализовать конструктор, принимающей значение числа соответствующего типа, для ByteInteger - byte,
ShortInteger - short и IntInteger - int.
Реализовать унаследованные публичные методы String toString(), посредством которых возвращать приведенное к строке
значение соответствующего классу типа.
2.3 У класса AbsInteger реализовать метод static AbsInteger add(AbsInteger num1, AbsInteger num2) - который вычисляет
сумму num1 и num2. При этом надо учесть, что num1 и num2 могут быть разных типов. Для того,
чтобы это реализовать продумать, какие дополнительные методы нужно сделать у AbsInteger и его потомков.

Привести результат к наиболее подходящему типу, т.е. -128..127 это ByteInteger и т.д.
 */
package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int result = transformation(num1) + transformation(num2);

        if (result >= -128 && result <= 127) {
            return new ByteInteger((byte) result);
        }
        if (result >= -32768 && result <= 32767) {
            return new ShortInteger((short) result);
        }
        return new IntInteger(result);
    }

    static int transformation(AbsInteger value) {
        return Integer.parseInt(value.toString());
    }

    public static void main(String[] args) {
        System.out.println(add(new IntInteger(10), new IntInteger(20)));
        System.out.println(add(new ByteInteger((byte) 1), new ByteInteger((byte) 1)));
        System.out.println(add(new ShortInteger((short) 50), new ShortInteger((short) 70)));
    }
}
