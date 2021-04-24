package lesson9.part1.alishev_interface;

public class Dog implements AbleToMakeSound, AbleToMakeEat {
    @Override
    public void makeSound() {
        System.out.println("bark!");
    }

    @Override
    public void eat() {
        System.out.println("I am eating beef");
    }
}
