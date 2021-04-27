package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

public class BigAlgebra {

    public static void main(String[] args) {
        String testValue = "4819";
        int expValue = 199;

        long startTime = new Date().getTime();
        System.out.println("Start Time :" + startTime);
        BigDecimal bigDecimal = new BigDecimal(testValue);
        System.out.println("Result: " + ordinaryPow(bigDecimal, expValue));
        System.out.println("ordinaryPow() speed: " + (new Date().getTime() - startTime) + " mSec \n");

        startTime = new Date().getTime();
        System.out.println("Start Time :" + startTime);
        bigDecimal = new BigDecimal(testValue);
        System.out.println("Result: " + fastPow(bigDecimal, expValue));
        System.out.println("fastPow() speed: " + (new Date().getTime() - startTime) + " mSec \n");

        startTime = new Date().getTime();
        System.out.println("Start Time :" + startTime);
        bigDecimal = new BigDecimal(testValue);
        System.out.println("Result: " + fastPow2(bigDecimal, expValue));
        System.out.println("fastPow2() speed: " + (new Date().getTime() - startTime) + " mSec \n");

        startTime = new Date().getTime();
        System.out.println("Start Time :" + startTime);
        bigDecimal = new BigDecimal(testValue);
        System.out.println("Result: " + fastPow1(bigDecimal, expValue));
        System.out.println("fastPow1() speed: " + (new Date().getTime() - startTime) + " mSec \n");

        fibonacci(10);
    }

    // первоначальный вариант метода
    public static BigDecimal ordinaryPow(BigDecimal num, int pow) {
        BigDecimal oneStepNum = num;
        for (int i = 1; i < pow; i++) {
            num = num.multiply(oneStepNum);
        }
        return num;
    }

    /* сигнатура взята из инета.
    https://www.cyberforum.ru/java-j2se/thread2439699.html
     */
    private static BigDecimal fastPow2(BigDecimal num, int pow) {
        BigDecimal result = new BigDecimal("1");
        while (pow > 0) {
            if ((pow & 1) == 1) {
                result = result.multiply(num);
            }
            num = num.multiply(num);
            pow >>= 1;
        }
        return result;
    }

    /* сигнатура взята из инета.
http://xn----htbdsuo3h.xn--p1ai/%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC-%D0%B2%D0%BE%D0%B7%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D1%8F-%D1%87%D0%B8%D1%81%D0%BB%D0%B0-%D0%B2-%D1%81%D1%82%D0%B5%D0%BF%D0%B5%D0%BD%D1%8C/
     */
    public static BigDecimal fastPow1(BigDecimal x, int power) {
        ArrayList<BigDecimal> powerX = new ArrayList<>();
        powerX.add(x);
        BigDecimal xPowerN = x.multiply(x);
        powerX.add(xPowerN);
        int curPower = 2;
        while (curPower < power - 2) {
            xPowerN = xPowerN.multiply(xPowerN);
            powerX.add(xPowerN);
            curPower *= 2;
        }
        BigDecimal answer = BigDecimal.valueOf(1);
        for (int i = 0; i < powerX.size(); i++) {
            if ((power & (1 << i)) != 0) {
                answer = answer.multiply(powerX.get(i));
            }
        }
        return answer;
    }

    // мой вариант метода
    public static BigDecimal fastPow(BigDecimal num, int pow) {
        BigDecimal oneStepNum = num;
    //  пробовал разные. Оставил 5. Чтобы не удлинять время первого цикла
        int divider = 5;
    //  чтобы просто возводить числа до 50 в степень до 10
            if (new BigDecimal("50").compareTo(num) > 0 && pow < 10) {
                divider = 1;
            }
                for (int i = 1; i < divider; i++) {
                    num = num.multiply(oneStepNum);
                }
        BigDecimal twoStepNum = num;
        for (int i = 1; i < pow / divider; i++) {
            num = num.multiply(twoStepNum);
        }
            for (int i = 1; i <= pow % divider; i++) {
                num = num.multiply(oneStepNum);
            }
                return num;
    }

    public static BigInteger fibonacci(int n) {
        BigInteger presiousFiboNumber = new BigInteger("0");
        BigInteger currentFiboNumber = new BigInteger("1");
        BigInteger resultFiboNumber = new BigInteger("0");
        for (int i = 1; i <= n; i++) {
            if (i != 1) {
                resultFiboNumber = currentFiboNumber.add(presiousFiboNumber);
                presiousFiboNumber = currentFiboNumber;
                currentFiboNumber = resultFiboNumber;
            } else {
                resultFiboNumber = (new BigInteger("1"));
            }
            System.out.print("номер числа - " + i + " , ");
            System.out.println("значение числа Фибоначчи - " + resultFiboNumber);
        }
        System.out.println();
        return resultFiboNumber;
    }
}
