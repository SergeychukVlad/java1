package lesson5.part3;

public class Segment extends Figure {
    double a;

    Segment(double a) {
        this.a = a;
    }

    @Override
    double perimeter() {
        return a;
    }

    @Override
    public String toString() {
        return "Отрезок, длина " + a;
    }
}
