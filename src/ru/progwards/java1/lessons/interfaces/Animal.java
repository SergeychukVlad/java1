package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;
import java.util.Objects;

public class Animal implements FoodCompare, CompareWeight {

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

    enum FoodKind {UNKNOWN, HAY, CORN}

    double weight;

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight) {
        if (this.weight < ((Animal) smthHasWeight).getWeight()) {
            return CompareResult.LESS;
        }
        if (this.weight > ((Animal) smthHasWeight).getWeight()) {
            return CompareResult.GREATER;
        } else
            return CompareResult.EQUAL;
    }
//
//    public static void sort(CompareWeight[] a) {
//        CompareWeight buffer;
//        for (int i = 1; i < a.length; i++) {
//            for (int j = 0; j < a.length; j++) {
//                if (a[j].compareWeight(a[i]) == CompareResult.GREATER) {
//                    buffer = a[j];
//                    a[j] = a[i];
//                    a[i] = buffer;
//                }
//            }
//        }
//    }

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

    public double getFood1kgPrice() {
        return switch (getFoodKind()) {
            case HAY -> 20.0;
            case CORN -> 50.0;
            case UNKNOWN -> 0.0;
        };
    }

    public double getFoodPrice() {
        return getFood1kgPrice() * calculateFoodWeight();
    }

    public boolean equals(Object anObject) {
//       убедиться, что сравниваем объекты одного класса
//       вернуть true, если у объектов равный вес
        return anObject.getClass().equals(this.getClass()) && this.weight == ((Animal) anObject).weight;
    }

    static void myTesting() {
        Animal animal = new Animal(100.2);
        Cow cow = new Cow(350.2);
        Hamster hamster = new Hamster(2.2);
        Duck duck = new Duck(3.6);
        System.out.println(cow.compareFoodPrice(hamster));
        System.out.println(animal.compareFoodPrice(duck));
        System.out.println(Objects.equals(cow, duck));
        System.out.println(Objects.equals(cow, cow));
        Animal[] animals = {animal, cow, hamster, duck};
        ArraySort.sort(animals);
        System.out.println(Arrays.asList(animals));
    }

    public static void main(String[] args) {
        myTesting();
    }
}
