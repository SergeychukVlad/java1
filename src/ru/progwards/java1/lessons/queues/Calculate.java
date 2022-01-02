/*
Class Calculate, который содержит методы:

3.7 public static double calculation1(), возвращающую результат вычисления следующей формулы:
2.2*(3+12.1), используя класс StackCalc

3.8 public static double calculation2(), возвращающую результат вычисления следующей формулы:
(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)), используя класс StackCalc

 */
package ru.progwards.java1.lessons.queues;

import java.util.LinkedList;
import java.util.List;

public class Calculate {

    public static double calculation1() {
        LinkedList<Double> doubles = new LinkedList<>(List.of(2.2, 3.0, 12.1));
        StackCalc stackCalc = new StackCalc(doubles);

        double pop_result = stackCalc.pop();
        stackCalc.add();
        stackCalc.push(pop_result);
        stackCalc.mul();

        return doubles.get(0);
    }

    public static double calculation11() {
        LinkedList<Double> doubles = new LinkedList<>(List.of(3.0, 12.1));
        StackCalc stackCalc = new StackCalc(doubles);

        stackCalc.add();
        stackCalc.push(2.2);
        stackCalc.mul();

        return doubles.get(0);
    }

    public static double calculation2() {
        LinkedList<Double> doubles =
                new LinkedList<>(List.of(9.2, 13.001, 2.0, 87.0, 3.33, 19.0, 737.22, 24.0, 12.10, 55.60));
        StackCalc stackCalc = new StackCalc(doubles);

        stackCalc.sub();
        stackCalc.mul();
        stackCalc.add();
        double part1_result = stackCalc.pop();
        stackCalc.sub();
        stackCalc.push(part1_result);
        stackCalc.mul();
        part1_result = stackCalc.pop();
        stackCalc.add();
        double part2_result = stackCalc.pop();
        stackCalc.sub();
        double part3_result = stackCalc.pop();
        stackCalc.push(part2_result);
        stackCalc.push(part3_result);
        stackCalc.div();
        stackCalc.push(part1_result);
        stackCalc.add();
        return doubles.get(0);
    }


    public static void main(String[] args) {
        System.out.println(2.2 * (3 + 12.1) + " " + calculation11());
        System.out.println(2.2 * (3 + 12.1) + " " + calculation1());
        System.out.println((737.22 + 24) / (55.6 - 12.1) + (19 - 3.33) * (87 + 2 * (13.001 - 9.2)) + " " + calculation2());

    }
}
