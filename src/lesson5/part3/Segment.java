package lesson5.part3;

public class Segment extends Figure {
    public final double a;

    public Segment(double a) {
        this.a = a;
    }

    @Override
    public double perimeter() {
        return a;
    }

    @Override
    public String toString() {
        return "Отрезок, длина " + a;
    }
}
