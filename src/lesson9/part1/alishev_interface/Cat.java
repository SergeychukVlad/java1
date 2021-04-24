package lesson9.part1.alishev_interface;

public class Cat implements AbleToMakeSound, AbleToMakeEat {
    @Override
    public void makeSound() {
        System.out.println("meow!");
    }

    @Override
    public void eat() {
        System.out.println("I am eating milk");
    }
}
