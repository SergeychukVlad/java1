package lesson5.part2;

public class Answers_part2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.getResult());

        System.out.println(calculator.set(5));
        System.out.println(calculator.getResult());

        System.out.println(calculator.add(10));
        System.out.println(calculator.getResult());

        System.out.println(calculator.sub(7));
        System.out.println(calculator.getResult());
    }
}
