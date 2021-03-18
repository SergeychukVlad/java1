package lesson5.part3;

import java.util.Arrays;

public class Figures {
    static Segment segment = new Segment(5);
    static Square square = new Square(5);
    static Rectangle rectangle = new Rectangle(5, 11);
    static Circle circle = new Circle(5);
    static Triangle triangle = new Triangle(3, 4, 5);

    static Figure[] figures = {segment, square, rectangle, circle, triangle};

    public static void printInfo(Figure figure) {
        System.out.println(figure);
        System.out.println("периметр: " + figure.perimeter());
        System.out.println("площадь : " + figure.area());
        System.out.println();
    }

    static void myTest() {
        printInfo(segment);
        printInfo(square);
        printInfo(rectangle);
        printInfo(circle);
        printInfo(triangle);
    }

    static void interfaceUsage() {
        for (var figure : figures) {
            printInfo(figure);
        }

        System.out.println("segment.compareTo(square)   = " + segment.compareTo(square));
        System.out.println("square.compareTo(square)   = " + square.compareTo(square));
        System.out.println("square.compareTo(rectangle)   = " + square.compareTo(rectangle));
        System.out.println("circle.compareTo(triangle)   = " + circle.compareTo(triangle));
        System.out.println("rectangle.compareTo(triangle)   = " + rectangle.compareTo(triangle));
    }

    static void genericUsage() {
        Arrays.sort(figures);
        for (var figure : figures) {
            printInfo(figure);
        }
    }

    public static void main(String[] args) {
        myTest();
        interfaceUsage();
        System.out.println();
        genericUsage();
    }
}
