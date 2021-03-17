package lesson8.part1;

import java.util.Objects;

public class Answer_part1 {
    class Rectangle {
        private double a;
        private double b;

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double area() {
            return a * b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rectangle rectangle = (Rectangle) o;
            if (this.area() == rectangle.area()) return true;
            return Double.compare(rectangle.a, a) == 0 && Double.compare(rectangle.b, b) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
