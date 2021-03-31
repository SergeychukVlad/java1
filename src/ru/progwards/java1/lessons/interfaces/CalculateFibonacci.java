package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;

    public static class CacheInfo {
        public int n = 4;
        public int fibo;
    }

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static int fiboNumber(int n) {
        if (lastFibo != null) {
            if (lastFibo.n == n) {
                return lastFibo.fibo;
            }
        }
        lastFibo = new CacheInfo();
        int presiousFiboNumber = 0;
        int currentFiboNumber = 1;
        int resultFiboNumber = 0;

        for (int i = 0; i <= n; i++) {
            if (i == 1) {
                resultFiboNumber = 1;
            }
            if (i > 1) {
                resultFiboNumber = currentFiboNumber + presiousFiboNumber;
                presiousFiboNumber = currentFiboNumber;
                currentFiboNumber = resultFiboNumber;
            }
        }
        lastFibo.n = n;
        lastFibo.fibo = resultFiboNumber;
        return getLastFibo().fibo;
    }

    public static void myTesting() {
        clearLastFibo();
        fiboNumber(15);
        System.out.print("n = " + lastFibo.n + ", ");
        System.out.println("Fibonacci = " + lastFibo.fibo);
        fiboNumber(new CacheInfo().n);
        System.out.print("n = " + lastFibo.n + ", ");
        System.out.println("Fibonacci = " + lastFibo.fibo);
    }

    public static void main(String[] args) {
        myTesting();
    }
}