package lesson8.part3;

public class NestedFigures {
    // вложенные классы-фигуры
    public static abstract class Figure implements Comparable<lesson5.part3.Figure> {
        @Override
        public int compareTo(lesson5.part3.Figure object) {
            return Double.compare(this.area(), object.area());
        }

        // периметр фигуры
        abstract double perimeter();

        // площадь фигуры
        double area() {
            return 0d;
        }
    }

    public static class Segment extends lesson5.part3.Figure {
        double a;

        Segment(double a) {
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

    public static class Square extends Segment {
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

    public static final class Rectangle extends Square {
        double b;

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

    public static class Circle extends lesson5.part3.Figure {
        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return "Окружность с радиусом " + radius;
        }
    }

    public static class Triangle extends Segment {
        double b, c;

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
}
