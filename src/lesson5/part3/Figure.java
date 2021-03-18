package lesson5.part3;

public abstract class Figure implements Comparable<Figure> {
    @Override
    public int compareTo(Figure object) {
        return Double.compare(this.area(), object.area());
    }

    // периметр фигуры
    abstract double perimeter();

    // площадь фигуры
    double area() {
        return 0d;
    }
}