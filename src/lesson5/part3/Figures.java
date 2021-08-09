package lesson5.part3;

import lesson8.part3.NestedFigures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Figures {
    static Segment segment = new Segment(5);
    static Square square = new Square(5);
    static Rectangle rectangle = new Rectangle(5, 11);
    static Circle circle = new Circle(5);
    static Triangle triangle = new Triangle(3, 4, 5);

    static Figure[] figures = {segment, square, rectangle, circle, triangle};

    static void myTest() {
        segment.printInfo();
        square.printInfo();
        rectangle.printInfo();
        circle.printInfo();
        triangle.printInfo();
    }

    static void interfaceUsage() {
        for (var figure : figures) {
            figure.printInfo();
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
            figure.printInfo();
        }
    }

    public static void workWithArrayList() {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Segment(5));
        figures.add(new Square(5));
        figures.add(new Rectangle(5, 11));
        figures.add(new Circle(5));
        figures.add(new Triangle(3, 4, 5));

        for (Figure figure : figures) {
            figure.printInfo();
        }
    }

    public static void workWithList() {
        NestedFigures figures = new NestedFigures();
        figures.list.add(new NestedFigures.Segment(5));
        figures.list.add(new NestedFigures.Square(5));
        figures.list.add(new NestedFigures.Rectangle(5, 11));
        figures.list.add(new NestedFigures.Circle(5));
        figures.list.add(new NestedFigures.Triangle(3, 4, 5));

//        figures.list.remove(figures.maxFigure());
//        figures.list.remove(figures.minFigure());

// 'элегантное расходование ресурсов
//        figures.list.sort(figures.list);
        figures.list.sort(null);
        if(!figures.list.isEmpty()) {
            figures.list.remove(0);
        }
        if(!figures.list.isEmpty()) {
            figures.list.remove(figures.list.size() - 1);
        }

        for (NestedFigures.Figure figure : figures.list) {
//            figure.printInfo();
        }

        for (int i = 0; i < figures.list.size(); i++) {
//            figures.list.get(i).printInfo();
        }
    }

    public static void main(String[] args) {
//        myTest();
//        interfaceUsage();
//        System.out.println();
//        genericUsage();

        workWithArrayList();
        workWithList();
    }
}
