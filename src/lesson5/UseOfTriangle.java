package lesson5;

import javax.management.MBeanAttributeInfo;
import javax.management.ObjectName;

public class UseOfTriangle {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(3, 4, 5);
        Triangle triangle2 = new Triangle(5, 5, 5);
        Triangle triangle3 = new Triangle(3, 3, 5);

        TriangleOnStatic triangleOnStatic1 = TriangleOnStatic.makeTriangle(7, 5, 14);
        TriangleOnStatic triangleOnStatic2 = TriangleOnStatic.makeTriangle(7, 5, 10);

        System.out.println("Периметр triangle1 : " + triangle1.perimeter());
        System.out.println("Площадь triangle1  : " + triangle1.area());

        System.out.println("Периметр triangle2 : " + triangle2.perimeter());
        System.out.println("Площадь triangle2  : " + triangle2.area());

        System.out.println("Периметр triangle3 : " + triangle3.perimeter());
        System.out.println("Площадь triangle3  : " + triangle3.area());

        if (triangleOnStatic1 == null) {
            System.out.println("Треугольника triangleOnStatic1 с такими сторонами не существует!");
        } else {
            System.out.println("Треугольник triangleOnStatic1 со сторонами: "
                    + triangleOnStatic1.a + ", " + triangleOnStatic1.b + ", " + triangleOnStatic1.c + " создан!");
            System.out.println("Периметр triangleOnStatic1 : " + triangleOnStatic1.perimeter());
            System.out.println("Площадь triangleOnStatic1  : " + triangleOnStatic1.area());
        }
        if (triangleOnStatic2 == null) {
            System.out.println("Треугольника triangleOnStatic2 с такими сторонами не существует!");
        } else {
            System.out.println("Треугольник triangleOnStatic2 со сторонами: "
                    + triangleOnStatic2.a + ", " + triangleOnStatic2.b + ", " + triangleOnStatic2.c + " создан!");
            System.out.println("Периметр triangleOnStatic2 : " + triangleOnStatic2.perimeter());
            System.out.println("Площадь triangleOnStatic2  : " + triangleOnStatic2.area());
        }
    }
}
