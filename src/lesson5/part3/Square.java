package lesson5.part3;

public class Square extends Segment {
    public Square(double a) {
        super(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return Double.compare(square.a, a) == 0;
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
