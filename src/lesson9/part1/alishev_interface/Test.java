package lesson9.part1.alishev_interface;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.makeSound();
        dog.eat();

        cat.makeSound();
        cat.eat();

        System.out.println("------");

        Woman woman = new Woman();
        woman.eat();
        woman.makeSound();
        woman.makeUp();

        Man man = new Man();
        man.eat();
        man.makeChildren();
    }
}
