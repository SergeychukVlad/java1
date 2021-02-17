package lesson3;

public class Test_3_2 {
    public static void main(String[] args) {
        System.out.println(toDouble("55.2"));
        maxInt();
        System.out.println(toInt("12"));
    }

    static double toDouble(String str) {
        return Double.valueOf(str);
    }

    static int maxInt() {
        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);
        return maxValue;
    }

    static int toInt(String str) {
        return Integer.parseInt(str);

    }
}
