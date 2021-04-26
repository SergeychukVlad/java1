package lesson9.part3;

import java.math.BigDecimal;
import java.math.MathContext;

public class MathContextExample1 {
    public static void main(String[] args) {
        BigDecimal bigDecimal0 = new BigDecimal("12345");
        BigDecimal bigDecimal1 = new BigDecimal("0.54321");
        MathContext mathContext = new MathContext(1);
        BigDecimal result = bigDecimal0.add(bigDecimal1, mathContext);
        System.out.println("result = " + result);
        System.out.println("result.unscaledValue = " + result.unscaledValue());
        System.out.println("result.scale = " + result.scale());
    }
}
