package lesson9.part3;

import java.math.BigDecimal;

public class ArithmeticOperationsScale {
    public static void main(String[] args) {
        BigDecimal bigDec1 = new BigDecimal("5.5");
        BigDecimal bigDec2 = new BigDecimal("1.0");
        System.out.println("bigDec1 = " + bigDec1);
        System.out.println("bigDec1.unscaledValue = " + bigDec1.unscaledValue());
        System.out.println("bigDec1.scale = " + bigDec1.scale());
        System.out.println("bigDec2 = " + bigDec2);
        System.out.println("bigDec2.unscaledValue = " + bigDec2.unscaledValue());
        System.out.println("bigDec2.scale = " + bigDec2.scale());
        System.out.println("--------------------------");

        BigDecimal result0 = bigDec1.add(bigDec2);
        System.out.println("result0 = " + result0);
        System.out.println("result0.unscaledValue = " + result0.unscaledValue());
        System.out.println("result0.scale = " + result0.scale());
        System.out.println("--------------------------");

        BigDecimal result1 = bigDec1.multiply(bigDec2);
        System.out.println("result1 = " + result1);
        System.out.println("result1.unscaledValue = " + result1.unscaledValue());
        System.out.println("result1.scale = " + result1.scale());
        System.out.println("--------------------------");
    }
}
