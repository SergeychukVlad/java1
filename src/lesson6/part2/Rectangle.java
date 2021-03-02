package lesson6.part2;

public class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a * b;
    }

    public int compareTo(Rectangle anRectangle) {
        if (this.area() > anRectangle.area()) {
            return 1;
        }
        if (this.area() < anRectangle.area()) {
            return -1;
        } else {
            return 0;
        }
    }

    static void myTest() {
        System.out.println(new Rectangle(2, 1).compareTo(new Rectangle(2, 3)));
        System.out.println(new Rectangle(2, 6).compareTo(new Rectangle(2, 3)));
        System.out.println(new Rectangle(2, 1).compareTo(new Rectangle(2, 1)));
    }

    public static void main(String[] args) {
        myTest();
    }
}
