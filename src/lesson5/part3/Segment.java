package lesson5.part3;

import java.util.Objects;

public class Segment extends Figure {
    public final double a;

    public Segment(double a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (!(o instanceof Segment)) return false;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return Double.compare(segment.a, a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
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
