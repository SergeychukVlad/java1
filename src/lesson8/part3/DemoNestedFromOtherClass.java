package lesson8.part3;

import java.util.Arrays;

import static lesson8.part3.NestedFigures.*;

public class DemoNestedFromOtherClass {
    public static void main(String[] args) {
        Segment segment = new Segment(5);
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(5, 11);
        Circle circle = new NestedFigures.Circle(5);
        Triangle triangle = new Triangle(3, 4, 5);
        Segment[] figures = {segment, square, rectangle, triangle};

        Arrays.sort(figures);
        for (var figure : figures) {
            printInfo(figure);
        }
    }
}
