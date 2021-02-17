package lesson3;

public class WrapperValueOf {
    public static void main(String[] args) {
        Integer int1 = Integer.valueOf(5);
        Integer int2 = Integer.valueOf("6669");

        Double aDouble1 = Double.valueOf(5);
        Double aDouble2 = Double.valueOf(5.0);
        Double aDouble3 = Double.valueOf("55.00");

        System.out.println(int1);
        System.out.println(int2);
        System.out.println(aDouble1);
        System.out.println(aDouble2);
        System.out.println(aDouble3);
    }
}
