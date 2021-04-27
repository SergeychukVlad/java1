package ru.progwards.java1.lessons.bigints;

public class ByteInteger extends AbsInteger {
    byte value;

    public ByteInteger(byte value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(Integer.valueOf(value));
    }
}
