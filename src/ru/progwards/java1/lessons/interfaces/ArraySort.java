package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort implements CompareWeight {
    public int value;

    public ArraySort(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthValue) {
        if (this.value < ((ArraySort) smthValue).getValue()) {
            return CompareResult.LESS;
        }
        if (this.value > ((ArraySort) smthValue).getValue()) {
            return CompareResult.GREATER;
        } else
            return CompareResult.EQUAL;
    }

    public static void sort(CompareWeight[] a) {
        CompareWeight buffer;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j].compareWeight(a[i]) == CompareWeight.CompareResult.GREATER) {
                    buffer = a[j];
                    a[j] = a[i];
                    a[i] = buffer;
                }
            }
        }
    }

    public static void myTesting() {
        ArraySort[] values = {new ArraySort(500), new ArraySort(169), new ArraySort(1024),
                new ArraySort(100), new ArraySort(7)};
        sort(values);
        for (int i = 0; i < values.length; i++) {
            System.out.println(Arrays.asList(values).get(i).getValue());
        }
    }

    public static void main(String[] args) {
        myTesting();
    }
}