package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    public Integer N;
    private boolean[] sieve;

    public Eratosthenes(int n) {
        this.sieve = new boolean[n + 1];
        this.N = n + 1;
        Arrays.fill(sieve, true);
//  целое положительное число Х является простым, если оно больше 1 и при этом делится без остатка только на 1 и на Х
        sieve[0] = false;
        sieve[1] = false;
        sift();
    }

    private void sift() {
        int p = 2;
        for (int i = p; i < N - 1; i++) {

            for (int j = 1; i * j < N; j++) {
                if (i * j > p) {
                    sieve[i * j] = false;
                }
            }

            for (int k = 2; k < sieve.length; k++) {
                if (k > p && sieve[k]) {
                    p = k;
                    break;
                }
            }
        }
    }

    public boolean isSimple(int n) {
        return sieve[n];
    }

    static void myTest() {
        Eratosthenes eratosthenes = new Eratosthenes(30);
        System.out.println(Arrays.toString(eratosthenes.sieve));
        System.out.println();
        System.out.println(eratosthenes.isSimple(4));
        System.out.println(eratosthenes.isSimple(12));
        System.out.println(eratosthenes.isSimple(3));
        System.out.println(eratosthenes.isSimple(22));
        System.out.println(eratosthenes.isSimple(11));
        System.out.println(eratosthenes.isSimple(10));
        System.out.println(eratosthenes.isSimple(13));
    }

    public static void main(String[] args) {
        myTest();
    }
}
