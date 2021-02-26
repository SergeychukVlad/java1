package lesson5.part3;

public class Figures {
    public static void printInfo(Figure figure) {
        System.out.println(figure);
        System.out.println("периметр: " + figure.perimeter());
        System.out.println("площадь : " + figure.area());
        System.out.println();
    }

    public static void main(String[] args) {
        Segment segment = new Segment(5);
        printInfo(segment);
        Square square = new Square(5);
        printInfo(square);
        Rectangle rectangle = new Rectangle(5, 11);
        printInfo(rectangle);
        Circle circle = new Circle(5);
        printInfo(circle);
        Triangle triangle = new Triangle(3, 4, 5);
        printInfo(triangle);
    }
}
