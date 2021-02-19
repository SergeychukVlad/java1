package lesson4;

public class CastTypes {
    public static void main(String[] args) {
        castTypes1((byte) 127);
        System.out.println("------------------------------------------");

        castTypes2(55);
        System.out.println("------------------------------------------");

        castTypes2(333_555_777_999L);
        System.out.println("------------------------------------------");

        castTypes3(333777555.999123005);
        System.out.println("------------------------------------------");

        castTypes3(1E308);
        System.out.println("------------------------------------------");

        castTypes4(123.5555555555);
        System.out.println("------------------------------------------");

        castTypes4(9999999999999999999999999999999.5555555555);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("------------------------------------------");
    }

    public static void castTypes1(byte byteValue) {
        System.out.println("byteValue = " + byteValue);

        short shortValue = byteValue;
        System.out.println("shortValue = " + shortValue);

        int intValue = shortValue;
        System.out.println("intValue = " + intValue);

        long longValue = intValue;
        System.out.println("longValue = " + longValue);

        float floatValue = longValue;
        System.out.println("floatValue = " + floatValue);

        double doubleValue = floatValue;
        System.out.println("doubleValue = " + doubleValue);
    }

    public static void castTypes2(long longValue) {
        System.out.println("longValue = " + longValue);

        int intValue = (int) longValue;
        System.out.println("intValue = " + intValue);

        short shortValue = (short) longValue;
        System.out.println("shortValue = " + shortValue);

        byte byteValue = (byte) longValue;
        System.out.println("byteValue = " + byteValue);
    }

    public static void castTypes3(double doubleValue) {
        System.out.println("doubleValue = " + doubleValue);

        float floatValue = (float) doubleValue;
        System.out.println("floatValue = " + floatValue);

        System.out.println("Значение floatValue равно Infinity? " + Float.isInfinite(floatValue));
        System.out.println("Сумма floatValue + 555 даёт результат: " + (floatValue + 555));
        System.out.println("Выражение doubleValue / floatValue даёт результат: " + (doubleValue / floatValue));
    }

    public static void castTypes4(double doubleValue) {
        System.out.println("doubleValue = " + doubleValue);

        long longValue = (long) doubleValue;
        System.out.println("longValue = " + longValue);

        int intValue = (int) doubleValue;
        System.out.println("intValue = " + intValue);

        short shortValue = (short) doubleValue;
        System.out.println("shortValue = " + shortValue);

        byte byteValue = (byte) doubleValue;
        System.out.println("byteValue = " + byteValue);
    }
}
