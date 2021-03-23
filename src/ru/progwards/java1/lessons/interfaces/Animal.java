package ru.progwards.java1.lessons.interfaces;

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
//      если предполагается отрицательная масса, создаём объект с массой 0.0, чтобы дальше проверить и сообщить
//      static make...() в классах-потомках - не используются.
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 0.0;
        }
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
        if (animal.weight > 0.0) {
            System.out.println(animal.toString());
            System.out.println(animal.toStringFull());
        } else {
            System.out.println("Поэтому информация по весу призрака не предоставляется");
        }
        System.out.println();
    }

    static void myTesting() {
        Animal animal = new Animal(100.2);
        System.out.println("Создаём " + AnimalKind.ANIMAL + " с весом " + animal.weight);
        printStringInfo(animal);
        animal = new Animal(0);
        System.out.println("Создаём " + AnimalKind.ANIMAL + " с весом " + animal.weight);
        printStringInfo(animal);

        Cow cow = new Cow(350.2);
        System.out.println("Создаём " + AnimalKind.COW + " с весом " + cow.weight);
        printStringInfo(cow);
        cow = new Cow(-7.0);
        System.out.println("Создаём " + AnimalKind.COW + " с весом " + cow.weight);
        printStringInfo(cow);

        Hamster hamster = new Hamster(2.2);
        System.out.println("Создаём " + AnimalKind.HAMSTER + " с весом " + hamster.weight);
        printStringInfo(hamster);

        Duck duck = new Duck(3.6);
        System.out.println("Создаём " + AnimalKind.DUCK + " с весом " + duck.weight);
        printStringInfo(duck);
    }

    public static void main(String[] args) {
        myTesting();
    }
}
