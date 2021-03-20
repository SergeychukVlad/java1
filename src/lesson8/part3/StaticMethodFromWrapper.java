package lesson8.part3;

public class StaticMethodFromWrapper {
    public static void main(String[] args) {
        double a = 1.2345;
        double b = 5.4321;

        Double obj1 = 55.555;
        double maxAB = obj1.max(a, b);
        System.out.println("compareAB = " + maxAB);
    }
}