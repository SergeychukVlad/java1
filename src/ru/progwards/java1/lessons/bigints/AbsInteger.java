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
