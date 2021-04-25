package lesson9.part1.alishev_abstract;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.makeSound();
        dog.eat();

        cat.makeSound();
        cat.eat();

        Woman woman = new Woman();
        woman.hasWeight();
        woman.makeUp();

        Man man = new Man();
        man.eat();
        man.makeChildren();
    }
}
