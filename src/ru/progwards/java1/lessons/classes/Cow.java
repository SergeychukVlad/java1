package ru.progwards.java1.lessons.classes;

public class Cow extends Animal {
    public Cow(double weight) {
        super(weight);
    }

    public static Cow makeCow(double weight) {
        System.out.println("Создаём " + AnimalKind.COW + " с весом " + weight);
        if (weight > 0.0) {
            return new Cow(weight);
        } else {
            System.out.println("Да быть не может такой бесплотной " + AnimalKind.COW);
            return null;
        }
    }

    public AnimalKind getKind() {
        return AnimalKind.COW;
    }

    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    public double getFoodCoeff() {
        return 0.05;
    }
}
