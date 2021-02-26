package lesson5.part2;

public class Car {
    // свойства
    public final String brand;
    public final String model;
    public final int maxSpeed;
    public String color = "not valid";
    private int currentSpeed;

    // конструктор
    public Car(String brand, String model, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public String getInfo() {
        return "Car: " + brand + "\n" + "Model: " + model + "\n" + "MaxSpeed: " + maxSpeed;
    }

    public int changeSpeed(int value) {
        currentSpeed += value;
        if (currentSpeed > maxSpeed) {
            System.out.println("Недопустимая скорость: " + getCurrentSpeed() + " км/ч. Превышение: " + (getCurrentSpeed() - maxSpeed) + " км/ч! Ограничиваем до максимальной!");
            currentSpeed = maxSpeed;
        }
        return currentSpeed;
    }
}