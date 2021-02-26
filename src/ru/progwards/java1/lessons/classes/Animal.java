package ru.progwards.java1.lessons.classes;

public class Animal {
    public double weight;

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

    enum FoodKind {UNKNOWN, HAY, CORN}

    public Animal(double weight) {
        this.weight = weight;
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind();
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }

    public String toStringFull() {
        return "I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight();
    }

    public static void printStringInfo(Animal animal) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        System.out.println(animal.toString());
        System.out.println(animal.toStringFull());
    }

    public static void main(String[] args) {
        Animal animal = new Animal(100.2);
        printStringInfo(animal);

        Cow cow = new Cow(420.5);
        printStringInfo(cow);

        Hamster hamster = new Hamster(2.2);
        printStringInfo(hamster);

        Duck duck = new Duck(3.6);
        printStringInfo(duck);
    }
}
