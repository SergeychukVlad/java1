package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    public Integer N;
    private boolean[] sieve;

    public Eratosthenes(int n) {
        this.sieve = new boolean[n];
        this.N = n;
        for (int i = 0; i < n; i++) {
            sieve[i] = true;
        }
    }

    private void sift() {
        for (int p = 2; p < N; p++) {
            for (int i = 0; i < N; i++) {
                if ((i % p == 0) & (i != p)) {
                    sieve[i] = false;
                }
            }
        }
    }

    public boolean isSimple(int n) {
        return sieve[n];
    }

    static void myTest() {
        int size = 30;
        Eratosthenes eratosthenes = new Eratosthenes(size);
        System.out.println(Arrays.toString(eratosthenes.sieve));
        eratosthenes.sift();
        System.out.println(Arrays.toString(eratosthenes.sieve));
        System.out.println(eratosthenes.isSimple(4));
        System.out.println(eratosthenes.isSimple(2));
        System.out.println(eratosthenes.isSimple(3));
        System.out.println(eratosthenes.isSimple(5));
        System.out.println(eratosthenes.isSimple(11));
        System.out.println(eratosthenes.isSimple(10));
    }

    public static void main(String[] args) {
        myTest();
    }
}
