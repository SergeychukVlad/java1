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
}
