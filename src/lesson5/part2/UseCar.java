package lesson5.part2;

public class UseCar {
    public static void main(String[] args) {
        Car jaguar = new Car("Jaguar", "F-TYPE", 300);
        Car ford = new Car("Ford", "Focus", 180);

        System.out.println(ford.getInfo());

        System.out.println(jaguar.getInfo());
        System.out.println("Current speed: " + jaguar.getCurrentSpeed());
        jaguar.changeSpeed(55);
        System.out.println("Current speed: " + jaguar.getCurrentSpeed());
        jaguar.changeSpeed(390);
        System.out.println("Current speed: " + jaguar.getCurrentSpeed());
    }
}
