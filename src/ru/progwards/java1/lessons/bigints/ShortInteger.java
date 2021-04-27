package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    short value;

    public ShortInteger(short value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(Integer.valueOf(value));
    }
}
