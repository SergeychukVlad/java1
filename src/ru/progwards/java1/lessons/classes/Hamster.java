package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal {
    public Hamster(double weight) {
        super(weight);
    }

    public static Hamster makeHamster(double weight) {
        System.out.println("Создаём " + AnimalKind.HAMSTER + " с весом " + weight);
        if (weight > 0.0) {
            return new Hamster(weight);
        } else {
            System.out.println("Да быть не может такого бесплотного " + AnimalKind.HAMSTER);
            return null;
        }
    }

    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }

    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    public double getFoodCoeff() {
        return 0.03;
    }
}
