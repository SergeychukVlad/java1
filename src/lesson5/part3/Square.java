package lesson5.part3;

public class Square extends Segment {
    Square(double a) {
        super(a);
    }

    @Override
    double area() {
        return a * a;
    }

    @Override
    double perimeter() {
        return 4 * a;
    }
}
