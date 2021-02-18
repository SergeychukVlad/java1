package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static void main(String[] args) {
        System.out.println("Объём шара с применением Double типа в расчётах: " + volumeBallDouble(6371.2));
//        System.out.println(volumeBallDouble(1.0));
        System.out.println("Объём шара с применением Float типа в расчётах: " + volumeBallFloat(6371.2f));
//        System.out.println(volumeBallFloat(1.0f));
        System.out.println("Разница расчётов Double vs Float: " + calculateAccuracy(6371.2));
    }

    public static double volumeBallDouble(double radius) {
        return (4.0 / 3) * 3.14 * radius * radius * radius;
    }

    public static float volumeBallFloat(float radius) {
        return (float) ((4.0f / 3) * 3.14 * radius * radius * radius);
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float) radius);
    }
}
