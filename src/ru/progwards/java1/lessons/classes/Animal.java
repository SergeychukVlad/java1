package ru.progwards.java1.lessons.classes;

public class Animal {
    public double weight;

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

    enum FoodKind {UNKNOWN, HAY, CORN}

    public static Animal makeAnimal(double weight) {
        System.out.println("Создаём " + AnimalKind.ANIMAL + " с весом " + weight);
        if (weight > 0.0) {
            return new Animal(weight);
        } else {
            System.out.println("Да быть не может такого бесплотного " + AnimalKind.ANIMAL);
            return null;
        }
    }

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
        if (animal != null) {
            System.out.println(animal.toString());
            System.out.println(animal.toStringFull());
        } else {
            System.out.println("Поэтому информация по весу призрака не предоставляется");
        }
        System.out.println();
    }

    static void myTesting() {
        Animal animal = makeAnimal(100.2);
        printStringInfo(animal);
        animal = makeAnimal(0);
        printStringInfo(animal);

        Cow cow = Cow.makeCow(350.2);
        printStringInfo(cow);
        cow = Cow.makeCow(-7.0);
        printStringInfo(cow);

        Hamster hamster = Hamster.makeHamster(2.2);
        printStringInfo(hamster);

        Duck duck = Duck.makeDuck(3.6);
        printStringInfo(duck);
    }

    public static void main(String[] args) {
        myTesting();
    }
}
