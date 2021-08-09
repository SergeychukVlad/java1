package lesson5.part3;

public abstract class Figure implements Comparable<Figure> {
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