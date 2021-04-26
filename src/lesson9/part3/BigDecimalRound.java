package lesson9.part3;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalRound {
    public static void main(String[] args) {
        BigDecimal bigDec0 = new BigDecimal("9876.54321");
        System.out.println("bigDec0 = " + bigDec0);
        System.out.println("bigDec0.unscaledValue = " + bigDec0.unscaledValue());
        System.out.println("bigDec0.scale = " + bigDec0.scale());
        System.out.println("---------------------------------------");

        MathContext mathContext = new MathContext(5);
        BigDecimal bigDec1 = new BigDecimal("9876.54321", mathContext);
        System.out.println("bigDec1 = " + bigDec1);
        System.out.println("bigDec1.unscaledValue = " + bigDec1.unscaledValue());
        System.out.println("bigDec1.scale = " + bigDec1.scale());
        System.out.println("---------------------------------------");

        BigDecimal result = bigDec1.round(new MathContext(4));
        System.out.println("result = " + result);
        System.out.println("result.unscaledValue = " + result.unscaledValue());
        System.out.println("result.scale = " + result.scale());

    }
}
