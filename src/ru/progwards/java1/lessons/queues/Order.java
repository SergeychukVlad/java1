package ru.progwards.java1.lessons.queues;

public class Order {
    static int id = 1;

    double sum;
    int num;

    public Order(double sum) {
        this.sum = sum;
        this.num = id++;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }
}
