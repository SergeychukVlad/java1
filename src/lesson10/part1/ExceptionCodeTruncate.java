package lesson10.part1;

public class ExceptionCodeTruncate {
    public static void main(String[] args) {
        try {
            System.out.println("В try будет исключение.");
            int e = 1 / 0;
            System.out.print("Жди ");
            System.out.print("кода ");
            System.out.println("отсечение!");
        } catch (Exception e) {
            System.out.println("А в блоке catch - лечение");
        }
    }
}
