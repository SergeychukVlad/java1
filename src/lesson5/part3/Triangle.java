package lesson5.part3;

public class Triangle extends Segment {
    final double b, c;

    Triangle(double a, double b, double c) {
        super(a);
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double hP = perimeter() / 2;
        return Math.sqrt(hP * (hP - a) * (hP - b) * (hP - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Треугольник со сторонами " + a + ", " + b + ", " + c;
    }
}
