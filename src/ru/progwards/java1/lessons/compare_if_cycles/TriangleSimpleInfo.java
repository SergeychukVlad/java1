package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {

    // Получает параметрами длины сторон треугольника, а вернуть должна наибольшую длину стороны
    public static int maxSide(int a, int b, int c) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        System.out.print("В треугольнике со сторонами: " + a + ", " + b + ", " + c + " ");
//      Сергей Алтунджи:
//      "В логических выражениях лучше использовать логические операторы && и ||. В других задачах у Вас так и сделано."
//      Следую...
        if (a >= b &&  a >= c) return a;
        if (b >= a && b >= c) return b;
        return c;
    }
    // Получает параметрами длины сторон треугольника, а вернуть должна наименьшую длину стороны
    public static int minSide(int a, int b, int c) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        System.out.print("В треугольнике со сторонами: " + a + ", " + b + ", " + c + " ");
        if (a <= b &&  a <= c) return a;
        if (b <= a && b <= c) return b;
        return c;
    }
    // Получает параметрами длины сторон треугольника, а вернуть должна: true - треугольник равносторонний, false - нет
    public static boolean isEquilateralTriangle(int a, int b, int c) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        System.out.print("Со сторонами: " + a + ", " + b + ", " + c + " ");
        if ((a + b) > c && (a + c) > b && (c + b) > a) {
            return a == b && b == c;
        }
        return false;
    }

    static void myTesting() {
        System.out.println("треугольник равностороний? " + isEquilateralTriangle(2, 2, 3));
        System.out.println("треугольник равностороний? " + isEquilateralTriangle(2, 3, 2));
        System.out.println("треугольник равностороний? " + isEquilateralTriangle(3, 2, 2));
        System.out.println("треугольник равностороний? " + isEquilateralTriangle(2, 2, 2));
        System.out.println("треугольник равностороний? " + isEquilateralTriangle(3, 3, 3));
        System.out.println("треугольник равностороний? " + isEquilateralTriangle(15, 15, 15));
    }

    public static void main(String[] args) {
        System.out.println(" наибольшая сторона треугольника: " + maxSide(25, 30, 15));
        System.out.println(" наименьшая сторона треугольника: " + minSide(50, 28, 20));
        myTesting();
    }
}