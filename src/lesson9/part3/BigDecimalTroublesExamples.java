package lesson9.part3;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTroublesExamples {
/*
        ЭТО МОЖЕТ ВЫЗВАТЬ ПРОБЛЕМЫ!
1. Инициализация при помощи double, float
2. Использование функции equals() для сравнения
3. Деление без указания способа округления

 */

    public static void bigDecimalDouble() {
        BigDecimal bigDec0 = new BigDecimal("1234.56789");
        System.out.println("bigDec0 = " + bigDec0);
        System.out.println("bigDec0.unscaledValue = " + bigDec0.unscaledValue());
        System.out.println("bigDec0.scale = " + bigDec0.scale());
        System.out.println("-----------------------");
        BigDecimal bigDec1 = new BigDecimal(1234.56789);
        System.out.println("bigDec1 = " + bigDec1);
        System.out.println("bigDec1.unscaledValue = " + bigDec1.unscaledValue());
        System.out.println("bigDec1.scale = " + bigDec1.scale());
        System.out.println("-----------------------");
        System.out.println("Для инициализации использовать строки!!! Вместо double/float");
        System.out.println("-----------------------");
    }

    public static void bigDecimalEquals() {
        BigDecimal bigDec0 = new BigDecimal("1234.567890000");
        System.out.println("bigDec0 = " + bigDec0);
        System.out.println("bigDec0.unscaledValue = " + bigDec0.unscaledValue());
        System.out.println("bigDec0.scale = " + bigDec0.scale());
        System.out.println("-----------------------");
        BigDecimal bigDec1 = new BigDecimal("1234.56789");
        System.out.println("bigDec1 = " + bigDec1);
        System.out.println("bigDec1.unscaledValue = " + bigDec1.unscaledValue());
        System.out.println("bigDec1.scale = " + bigDec1.scale());
        System.out.println("-----------------------");
        System.out.println("bigDec0 равен bigDec1? " + bigDec0.equals(bigDec1));
        System.out.println("-----------------------");
        System.out.println("Не использовать для сравнения функцию equals()! equals() сравнивает unscaledValue & scale!");
        System.out.print("Используем функцию compareTo() -> ");
        System.out.println("bigDec0.compareTo(bigDec1): " + bigDec0.compareTo(bigDec1));
        System.out.println("-----------------------");
    }

    public static void bigDecimalDivisionException() {
        BigDecimal bigDec0 = new BigDecimal(1);
        BigDecimal bigDec1 = BigDecimal.valueOf(3);
        BigDecimal result = bigDec0.divide(bigDec1);
        System.out.println("result = " + result);
        System.out.println("result.unscaledValue = " + result.unscaledValue());
        System.out.println("result.scale = " + result.scale());
        System.out.println("-----------------------");
    }

    public static void bigDecimalDivisionExceptionWithRounding() {
        BigDecimal bigDec0 = new BigDecimal(1);
        System.out.println("bigDec0 = " + bigDec0);
        System.out.println("bigDec0.unscaledValue = " + bigDec0.unscaledValue());
        System.out.println("bigDec0.scale = " + bigDec0.scale());

        BigDecimal bigDec1 = BigDecimal.valueOf(3);
        System.out.println("bigDec1 = " + bigDec1);
        System.out.println("bigDec1.unscaledValue = " + bigDec1.unscaledValue());
        System.out.println("bigDec1.scale = " + bigDec1.scale());
        System.out.println("-----------------------");

        BigDecimal result = bigDec0.divide(bigDec1, RoundingMode.HALF_UP);
        System.out.println("result = " + result);
        System.out.println("result.unscaledValue = " + result.unscaledValue());
        System.out.println("result.scale = " + result.scale());
        System.out.println("-----------------------");
        System.out.println("Нужно явно указать scale (количество знаков после запятой) при округлении! Чтобы не потерять точность!");
        System.out.println("-----------------------");
        result = bigDec0.divide(bigDec1, 5, RoundingMode.HALF_UP);
        System.out.println("result = " + result);
        System.out.println("result.unscaledValue = " + result.unscaledValue());
        System.out.println("result.scale = " + result.scale());
        System.out.println("-----------------------");
        System.out.println("Нужно явно указать MathContext (размер числа, который является значащей частью)! Округление реализуется автоматом!");
        System.out.println("-----------------------");
        result = bigDec0.divide(bigDec1, new MathContext(5));
        System.out.println("result = " + result);
        System.out.println("result.unscaledValue = " + result.unscaledValue());
        System.out.println("result.scale = " + result.scale());
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        bigDecimalDouble();
        bigDecimalEquals();
//        bigDecimalDivisionException();
        bigDecimalDivisionExceptionWithRounding();
    }
}
