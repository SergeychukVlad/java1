package lesson5.part3;

public class Rectangle extends Square {
    final double b;

    Rectangle(double a, double b) {
        super(a);
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double perimeter() {
        return 2 * (a + b);
    }

    @Override
    public String toString() {
        return "Прямоугольник со сторонами " + a + ", " + b;
    }
}
