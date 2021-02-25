package lesson5;

public class TriangleOnStatic {
    // свойства
    double a, b, c;

    // конструктор
    TriangleOnStatic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private static boolean isOK(double a, double b, double c) {
        return (a + b > c) && (b + c > a) && (a + c > b);
    }

    public static TriangleOnStatic makeTriangle(double a, double b, double c) {
        if (isOK(a, b, c)) return new TriangleOnStatic(a, b, c);
        else return null;
    }

    // конструктор для равнобедренного треугольника
    TriangleOnStatic(double base, double side) {
        this(base, side, side);
    }

    // методы
    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        //  считаем по формуле Герона
        double hP = perimeter() / 2;
        return Math.sqrt(hP * (hP - a) * (hP - b) * (hP - c));
    }
}
