package lesson9.part3;

import java.math.BigDecimal;
import java.util.Date;

public class BigDecimalVsDoubleSpeedTest {
    final static int ITERATION_COUNT = 100_000_000;
    static int bigDecimalResult = 0;
    static int doubleResult = 0;

    private static void bigDecimalCounter() {
        long startTime = new Date().getTime();
        BigDecimal result = new BigDecimal(0);
        for (int i = 0; i < ITERATION_COUNT; i++) {
            result = result.add(new BigDecimal("0.01"));
        }
        bigDecimalResult = (int) (new Date().getTime() - startTime);
        System.out.println("bigDecimalCounter: " + bigDecimalResult + " mSec, итог: " + result);
    }

    private static void doubleCounter() {
        long startTime = new Date().getTime();
        double result = 0.0;
        for (int i = 0; i < ITERATION_COUNT; i++) {
            result += 0.01;
        }
        doubleResult = (int) (new Date().getTime() - startTime);
        System.out.println("doubleCounter: " + (doubleResult) + " mSec, итог: " + result);
    }

    public static void main(String[] args) {
        bigDecimalCounter();
        doubleCounter();
        System.out.println("double быстрее BigDecimal в " + bigDecimalResult/doubleResult + " раз.");
    }
}
