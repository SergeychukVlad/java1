package lesson9.part1;

import lesson8.part3.NestedFigures;

public class FiguresCompare extends NestedFigures {
    static class CompareGr {
        boolean greater(Figure figure1, Figure figure2) {
            return figure1.perimeter() > figure2.perimeter();
        }
    }

    // свойства
    private Figure[] figures;
    public CompareGr figuresComparator = new CompareGr();

    // методы (конструкторы)
    FiguresCompare(Figure[] figures) {
        this.figures = figures;
    }

    FiguresCompare(Figure[] figures, CompareGr fc) {
        this(figures);
        figuresComparator = fc;
    }

    Figure getMaxFigure() {
        Figure result = null;
        for (Figure figure : figures) {
            if (result == null || figuresComparator.greater(figure, result)) {
                result = figure;
            }
        }
        return result;
    }

    public static void mainWithLocalClass() {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        Segment segment = new Segment(5);
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(5, 11);
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(3, 4, 5);
        Figure[] figures = {segment, square, rectangle, circle, triangle};
        for (Figure figure : figures) {
            System.out.println(figure);
        }
        System.out.println();

        FiguresCompare fc = new FiguresCompare(figures);
        System.out.println("Фигура с максимальным периметром: ");
        printInfo(fc.getMaxFigure());

        class FigureComparatorArea extends CompareGr {
            @Override
            boolean greater(Figure figure1, Figure figure2) {
                return figure1.area() > figure2.area();
            }

        }

        FigureComparatorArea fca = new FigureComparatorArea();
        FiguresCompare fcArea = new FiguresCompare(figures, fca);
        System.out.println("Фигура с максимальной площадью: ");
        printInfo(fcArea.getMaxFigure());
    }

    public static void mainWithAnonymousClass() {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        Segment segment = new Segment(5);
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(5, 11);
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(3, 4, 5);
        Figure[] figures = {segment, square, rectangle, circle, triangle};
        for (Figure figure : figures) {
            System.out.println(figure);
        }
        System.out.println();

        FiguresCompare fc = new FiguresCompare(figures);
        System.out.println("Фигура с максимальным периметром: ");
        printInfo(fc.getMaxFigure());

        FiguresCompare fcArea = new FiguresCompare(figures,
//                анонимный класс
                new CompareGr() {
                    @Override
                    boolean greater(Figure figure1, Figure figure2) {
                        return figure1.area() > figure2.area();
                    }
                }
        );

        System.out.println("Фигура с максимальной площадью: ");
        printInfo(fcArea.getMaxFigure());
    }

    public static void main(String[] args) {
        mainWithLocalClass();
        mainWithAnonymousClass();
    }
}
