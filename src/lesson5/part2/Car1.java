package lesson5.part2;

public class Car1 {
    String brand;
    String model;
    int maxSpeed;

    public Car1(String brand, String model, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public boolean isFasterThen(Car1 anotherCar) {
        return this.maxSpeed > anotherCar.maxSpeed;
    }
}
