package lesson5.part1;

public class Triangle {
    // свойства
    private double a, b, c;
    public boolean isOK;

    // конструктор
    public Triangle(double side_a, double side_b, double side_c) {
        a = side_a;
        b = side_b;
        c = side_c;

        isOK = a + b > c && b + c > a && a + c > b;
    }

    // конструктор для равнобедренного треугольника
    public Triangle(double base, double side) {
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
