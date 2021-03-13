package lesson7.part1;

public class CalcDecToBin {

    static String val2Digit(int value) {
        if (value == 10) {
            return "A";
        }
        if (value == 11) {
            return "B";
        }
        if (value == 12) {
            return "C";
        }
        if (value == 13) {
            return "D";
        }
        if (value == 14) {
            return "E";
        }
        if (value == 15) {
            return "F";
        }
        return Integer.toString(value);
    }

    static String decToBase(int value, int base) {
        String result = "";
        while (value > 0) {
            result = result + val2Digit(value % base);
            value = value / base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decToBase(15, 2));
        System.out.println(decToBase(7, 2));
        System.out.println(decToBase(254, 16));
    }
}
