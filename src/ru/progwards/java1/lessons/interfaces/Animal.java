package ru.progwards.java1.lessons.interfaces;

public class Animal implements FoodCompare {

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }

    double weight;

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

    enum FoodKind {UNKNOWN, HAY, CORN}

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
//       убедиться, что сравниваем объекты класса Animal
//       вернуть true, если у объектов равный вес
        return anObject instanceof Animal && this.weight == (((Animal) anObject).weight);
    }

    static void myTesting() {
        Animal animal = new Animal(100.2);
        Cow cow = new Cow(350.2);
        Hamster hamster = new Hamster(2.2);
        Duck duck = new Duck(3.6);
        System.out.println(cow.compareFoodPrice(hamster));
        System.out.println(animal.compareFoodPrice(duck));
        System.out.println(cow.equals(duck));
        System.out.println(cow.equals(cow));
    }

    public static void main(String[] args) {
        myTesting();
    }
}
