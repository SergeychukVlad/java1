package ru.progwards.java1.lessons.queues;

public class Order {
    static int id = 0;

    double sum;
    int num;

    public Order(double sum) {
        this.sum = sum;
        this.num = id++;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }
}
