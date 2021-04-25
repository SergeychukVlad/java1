package lesson9.part1.alishev_interface;

public class Woman implements AbleToMakeEat, AbleToMakeSound, AbleToMakeUp {
    @Override
    public void eat() {
        System.out.println("I am woman! I eat a lot of vegetables!");
    }

    @Override
    public void makeSound() {
        System.out.println("I am woman! I have to roof, when I am nervous!");
    }

    @Override
    public void makeUp() {
        System.out.println("I am Woman! I like making up myself!");
    }
}
