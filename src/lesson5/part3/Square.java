package lesson5.part3;

public class Square extends Segment {
    Square(double a) {
        super(a);
    }

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public double perimeter() {
        return 4 * a;
    }

    @Override
    public String toString() {
        return "Квадрат со стороной " + a;
    }
}
