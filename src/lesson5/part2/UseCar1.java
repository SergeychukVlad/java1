package lesson5.part2;

public class UseCar1 {
    public static void main(String[] args) {
        Car1 jaguar = new Car1("Jaguar", "F-TYPE", 300);
        Car1 ford = new Car1("Ford", "Focus", 180);
        Car1 niva = new Car1("AUTOVAZ", "Niva", 140);

        Car1 fastestCar = niva;
        if (ford.maxSpeed > fastestCar.maxSpeed) {
            fastestCar = ford;
        }
        if (jaguar.maxSpeed > fastestCar.maxSpeed) {
            fastestCar = jaguar;
        }
        System.out.println("Самая быстрая машина " + fastestCar.brand);

        fastestCar = niva;
        if (ford.isFasterThen(niva)) {
            fastestCar = ford;
        }
        if (jaguar.isFasterThen(fastestCar)) {
            fastestCar = jaguar;
        }
        System.out.println("Самая быстрая машина " + fastestCar.brand);


    }
}
