package lesson10.part1;

public class FewExceptions {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            System.out.println((new int[5])[5]);
            int ex = 1 / 0;
            ((Object) null).toString();
        } catch (ArithmeticException e) {
            System.out.println("Произошло деление на ноль");
        } catch (NullPointerException e) {
            System.out.println("Обращение к объекту по ссылке null");
        } catch (Exception e) {
            System.out.println("Какое-то другое исключение");
        }
    }
}
