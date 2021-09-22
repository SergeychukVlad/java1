package lesson13.part2;

import lesson5.part3.Segment;
import lesson5.part3.Square;
import lesson8.part3.NestedFigures;

public class InstanceOfSimple {
    public static void main(String[] args) {
        String str = "Объект класса String";
        System.out.println(str instanceof String);
        System.out.println(str instanceof Object);

        Segment segment = new Segment(5);
        Square square = new Square(5);
        System.out.println("отрезок равен квадрату? " + segment.equals(square));
        System.out.println("квадрат равен отрезку? " + square.equals(segment));
    }
}
