package lesson5.part3;

public abstract class Figure implements AreaComparable {
    @Override
    public int compareArea(Figure figure) {
        return Double.compare(this.area(), figure.area());
    }
    // периметр фигуры
    abstract double perimeter();

    // площадь фигуры
    double area() {
        return 0d;
    }
}