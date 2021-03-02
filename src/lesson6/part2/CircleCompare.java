package lesson6.part2;

import lesson5.part3.Circle;

public class CircleCompare {
    static void myTest1() {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(5);

        System.out.println(circle1 == circle2);
        System.out.println(circle1.equals(circle2));
    }

    public static void main(String[] args) {
        myTest1();
    }
/*
1. Объекты правильно определять на равенство методом equals()
2. Метод equals() наследуется от класса Object, прародителя всех классов
3. Поэтому equals() необходимо переопределять для работы с собственными классами
 */
}
