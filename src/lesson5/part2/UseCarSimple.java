package lesson5.part2;

public class UseCarSimple {
    public static void main(String[] args) {
        CarSimple jaguar = new CarSimple();
        System.out.println("Марка " + jaguar.brand);
        System.out.println("Модель " + jaguar.model);
        System.out.println("Макс. скорость " + jaguar.maxSpeed);

        jaguar.brand = "Jaguar";
        jaguar.model = "F-TYPE";
        jaguar.maxSpeed = 300;

        System.out.println("Марка " + jaguar.brand);
        System.out.println("Модель " + jaguar.model);
        System.out.println("Макс. скорость " + jaguar.maxSpeed);
    }
}
