package lesson9.part3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalIntro {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("12345.54321");
        BigDecimal bigDecimalInt = new BigDecimal("12345");
        BigDecimal bigDecimalFrac = new BigDecimal("0.54321");
        System.out.println("bigDecimal = " + bigDecimal);

        BigDecimal result0 = bigDecimal.subtract(bigDecimalFrac);
        BigDecimal result1 = bigDecimal.subtract(bigDecimalInt);
        BigDecimal result2 = result0.add(result1);

        System.out.println("result0 = " + result0);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("---------------------");
        System.out.println("result2 * 10 = " + result2.multiply(BigDecimal.TEN));
        System.out.println("result2 / 10 = " + result2.divide(BigDecimal.TEN));
        System.out.println("result2 / 10 = " + result2.divide(new BigDecimal(17), RoundingMode.HALF_UP));
    }
}
