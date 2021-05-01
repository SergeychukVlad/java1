package lesson10.part2;

public class ThrowsAnyLevel {
    public static void functionA() {
        System.out.println("functionA start");
        functionB();
        System.out.println("functionA finish");
    }

    public static void functionB() {
        System.out.println("functionB start");
        functionC();
        System.out.println("functionB finish");
    }

    public static void functionC() {
        System.out.println("functionC start");
        int x = 1 / 0;
        System.out.println("functionC finish");
    }

    public static void main(String[] args) {
        try {
            functionA();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
