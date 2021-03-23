package ru.progwards.java1.lessons.interfaces;

public class Duck extends Animal {
    public Duck(double weight) {
        super(weight);
    }

    public static Duck makeDuck(double weight) {
        System.out.println("Создаём " + AnimalKind.DUCK + " с весом " + weight);
        if (weight > 0.0) {
            return new Duck(weight);
        } else {
            System.out.println("Да быть не может такого бесплотного " + AnimalKind.DUCK);
            return null;
        }
    }

    public AnimalKind getKind() {
        return AnimalKind.DUCK;
    }

    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    public double getFoodCoeff() {
        return 0.04;
    }
}