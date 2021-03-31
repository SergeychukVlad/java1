package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {

    int weight;

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

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public static void myTesting() {
        Food food1 = new Food(123);
        Food food2 = new Food(300);
        Food food3 = new Food(300);

        System.out.println(food1.compareWeight(food2));
        System.out.println(food2.compareWeight(food1));
        System.out.println(food2.compareWeight(food3));
    }

    public static void main(String[] args) {
        myTesting();
    }

}
