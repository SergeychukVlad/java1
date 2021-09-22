package lesson13.part2;

import lesson5.part3.Segment;

import java.util.HashSet;
import java.util.Set;

public class Answer_2 {

    class Figure {

    }

    class Square extends Figure {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        public double getSide() {
            return side;
        }
    }

    class Round extends Figure {
        private double diameter;

        public Round(double diameter) {
            this.diameter = diameter;
        }

        public double getDiameter() {
            return diameter;
        }
    }

    public static String figDetect(Figure fig) {
        if (fig instanceof Square)
            return "Сторона квадрата " + ((Square) fig).getSide();
        else if (fig instanceof Round)
            return "Диаметр круга " + ((Round) fig).getDiameter();
        else return "Неизвестная фигура";
    }

    public static void unionOfSets(final Set set1, final Set set2) {
        HashSet result = new HashSet(set1);
        result.addAll(set2);
        System.out.println(result.size());
    }

    public static void main(String[] args) {
        Set<Integer> intSet1 = Set.of(1, 3, 5, 12, 45);
        Set<Integer> intSet2 = Set.of(12, 44, 2, 1, 4);

        unionOfSets(intSet1, intSet2);

    }
}
