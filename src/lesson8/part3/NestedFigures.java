package lesson8.part3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NestedFigures {
    public List<Figure> list = new ArrayList<>();

    public Figure maxFigure() {
        return Collections.max(list);
    }

    public Figure minFigure() {
        return Collections.min(list);
    }

    // вложенные классы-фигуры
    public static abstract class Figure implements Comparable<Figure> {
        @Override
        public int compareTo(Figure object) {
            return Double.compare(this.area(), object.area());
        }

        // периметр фигуры
        public abstract double perimeter();

        // площадь фигуры
        public double area() {
            return 0d;
        }
        // информация о фигуре

        public void printInfo() {
            System.out.println(this);
            System.out.println("периметр: " + perimeter());
            System.out.println("площадь : " + area());
            System.out.println();
        }

    }

    public static class Segment extends Figure {
        double a;

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

    public static class Square extends Segment {
        public Square(double a) {
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

        public Rectangle(double a, double b) {
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

    public static class Circle extends Figure {
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

        public Triangle(double a, double b, double c) {
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

    // статические методы
    public static void printInfo(Figure figure) {

        System.out.println(figure);
        System.out.println("периметр: " + figure.perimeter());
        System.out.println("площадь : " + figure.area());
        System.out.println();
    }

    public static void main(String[] args) {
        NestedFigures figures = new NestedFigures();
        figures.list.add(new Segment(5));
        figures.list.add(new Square(5));
        figures.list.add(new Rectangle(5, 11));
        figures.list.add(new Circle(5));
        figures.list.add(new Triangle(3, 4, 5));
        for (Figure figure : figures.list) {
            printInfo(figure);
        }
    }
}
