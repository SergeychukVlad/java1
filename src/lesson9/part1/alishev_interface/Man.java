package lesson9.part1.alishev_interface;

public class Man implements AbleToMakeEat, AbleToMakeChildren {
    @Override
    public void makeChildren() {
        System.out.println("I am man! I can make children!");
    }

    @Override
    public void eat() {
        System.out.println("I am man. I eat a lot of beef!");
    }
}
