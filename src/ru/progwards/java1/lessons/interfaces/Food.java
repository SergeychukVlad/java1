package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight) {
        if (this.weight < ((Food) smthHasWeight).getWeight()) {
            return CompareResult.LESS;
        }
        if (this.weight > ((Food) smthHasWeight).getWeight()) {
            return CompareResult.GREATER;
        } else
            return CompareResult.EQUAL;
    }

    public static void sort(CompareWeight[] a) {
        CompareWeight buffer;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j].compareWeight(a[i]) == CompareResult.GREATER) {
                    buffer = a[j];
                    a[j] = a[i];
                    a[i] = buffer;
                }
            }
        }
    }

    public static void myTesting() {
        Food food1 = new Food(123);
        Food food2 = new Food(300);
        Food food3 = new Food(300);

        System.out.println(food1.compareWeight(food2));
        System.out.println(food2.compareWeight(food1));
        System.out.println(food2.compareWeight(food3));

        Food[] foods = {new Food(500), new Food(169), new Food(1024), new Food(100)};
        sort(foods);
    }

    public static void main(String[] args) {
        myTesting();
    }

}
