package ru.progwards.java1.lessons.arrays;

public class DIntArray {
    private int[] intArray = {};

    public void add(int num) {
        int[] bufferArray = new int[intArray.length + 1];
        System.arraycopy(intArray, 0, bufferArray, 0, intArray.length);
        bufferArray[intArray.length] = num;
        intArray = bufferArray;
    }

    public void atInsert(int pos, int num) {
        int[] bufferArray = new int[intArray.length + 1];
        System.arraycopy(intArray, 0, bufferArray, 0, pos);
        for (int i = 0; i < pos; i++) {
            bufferArray[i] = intArray[i];
        }
        bufferArray[pos] = num;
        for (int i = pos; i < intArray.length; i++) {
            bufferArray[i + 1] = intArray[i];
        }
    }

    public void atDelete(int pos) {
        int[] bufferArray = new int[intArray.length - 1];
        for (int i = 0; i < pos; i++) {
            bufferArray[i] = intArray[i];
        }
        for (int i = pos; i < intArray.length - 1; i++) {
            bufferArray[i] = intArray[i + 1];
        }
    }

    public int at(int pos) {
        int result;
        result = intArray[pos];
        System.out.println();
        return result;
    }

    static void myTest() {
        DIntArray dIntArray = new DIntArray();
        dIntArray.add(105);
        dIntArray.add(-90);
        dIntArray.atInsert(1, 200);
        dIntArray.atInsert(2, -16);
        dIntArray.at(1);
        dIntArray.atDelete(0);
    }

    public static void main(String[] args) {
       myTest();
    }
}
