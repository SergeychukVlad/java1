package ru.progwards.java1.lessons.bigints;

public class IntInteger extends AbsInteger {
    public int value;

    public IntInteger(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(Integer.valueOf(value));
    }
}
