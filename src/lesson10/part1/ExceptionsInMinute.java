package lesson10.part1;

public class ExceptionsInMinute {
    public static void main(String[] args) {
        Object objectNull = null;
        try {
            objectNull.toString();
        } catch (Exception e) {
            System.out.println("Произошло исключение...");
        }
    }
}
