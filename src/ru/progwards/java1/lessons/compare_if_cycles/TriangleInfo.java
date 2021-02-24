package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {

    // Возвращает true, если по данным трём сторонам (a, b, c) можно построить треугольник.
    // Из геометрии известно, что в треугольнике длина каждой из сторон меньше суммы длин двух других сторон
    public static boolean isTriangle(int a, int b, int c) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        System.out.print("Есть длины сторон: " + a + ", " + b + ", " + c + " , ");
        return (a + b) > c && (a + c) > b && (c + b) > a;
    }

    // Возвращает true, если треугольник со сторонами a, b, c является прямоугольным.
    // Из геометрии известно, что для прямоугольного треугольника выполняется теорема Пифагора
    // (сумма квадратов катетов равна квадрату гипотенузы).
    public static boolean isRightTriangle(int a, int b, int c) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        System.out.print("Есть длины сторон: " + a + ", " + b + ", " + c + " , ");
        return ((a + b) > c && (a + c) > b && (c + b) > a) // треугольник ли это?
                &&
                ((a * a + b * b) == c * c || (a * a + c * c) == b * b || (b * b + c * c) == a * a);
    }

    // Возвращает true, если треугольник со сторонами a, b, c является равнобедренным.
    // Из геометрии известно, что в равнобедренном треугольнике есть две равные стороны.
    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        System.out.print("Есть длины сторон: " + a + ", " + b + ", " + c + " , ");
        return ((a + b) > c && (a + c) > b && (c + b) > a) // треугольник ли это?
                &&
                (a == b || b == c || a == c);
    }

    static void myTesting() {
        System.out.println("треугольник возможен? " + isTriangle(2, 2, 3));
        System.out.println("треугольник возможен? " + isTriangle(2, 3, 4));
        System.out.println("треугольник возможен? " + isTriangle(3, 2, 5));
        System.out.println("треугольник возможен? " + isTriangle(2, 3, 6));
        System.out.println("треугольник возможен? " + isTriangle(3, 3, 9));
        System.out.println();
        System.out.println("треугольник прямоугольный? " + isRightTriangle(3, 3, 4));
        System.out.println("треугольник прямоугольный? " + isRightTriangle(3, 4, 5));
        System.out.println();
        System.out.println("треугольник равносторонний? " + isIsoscelesTriangle(3, 1, 1));
        System.out.println("треугольник равносторонний? " + isIsoscelesTriangle(2, 2, 3));
        System.out.println("треугольник равносторонний? " + isIsoscelesTriangle(2, 3, 2));
        System.out.println("треугольник равносторонний? " + isIsoscelesTriangle(3, 2, 2));
        System.out.println("треугольник равносторонний? " + isIsoscelesTriangle(2, 2, 2));
        System.out.println("треугольник равносторонний? " + isIsoscelesTriangle(3, 3, 3));
    }

    public static void main(String[] args) {
        myTesting();
    }
}
