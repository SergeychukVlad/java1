/*
Задача 3. Класс StackCalc
Стековый калькулятор (есть даже такой стековый язык программирования - Forth).
Стек, это структура данных, работающая по принципу LIFO - last in first out (последний вошедший выходит первый),
это противоположность привычной очереди FIFO - first in first out - первый вошедший выходит первый

Реализовать class StackCalc, который содержит стек чисел с плавающей точкой (double).
Выбрать наиболее удобную для этого коллекцию. Реализовать методы работы со стеком:

3.1 public void push(double value) - положить value на вершину стека

3.2 public double pop() - взять (убрать) значение с вершины стека

3.3 public void add() - сложить 2 верхних значения на стеке, результат положить на стек.
В итоге в стеке должно быть на один элемент меньше

3.4 public void sub() - вычесть верхнее значение на стеке, из следующего по глубине, результат положить на стек.
В итоге в стеке должно быть на один элемент меньше

3.5 public void mul() - умножить 2 верхних значения на стеке, результат положить на стек.
В итоге в стеке должно быть на один элемент меньше

3.6 public void div() - поделить на верхнее значение на стеке, следующее по глубине, результат положить на стек.
В итоге в стеке должно быть на один элемент меньше

Class Calculate, который содержит методы:

3.7 public static double calculation1(), возвращающую результат вычисления следующей формулы:
2.2*(3+12.1), используя класс StackCalc

3.8 public static double calculation2(), возвращающую результат вычисления следующей формулы:
(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)), используя класс StackCalc
 */

package ru.progwards.java1.lessons.queues;

import java.util.LinkedList;
import java.util.List;

public class StackCalc {

    public LinkedList<Double> doubles;

    public StackCalc(LinkedList<Double> doubles) {
        this.doubles = doubles;
    }

    public LinkedList<Double> getDoubles() {
        return doubles;
    }

    public void push(double value) {
        doubles.addFirst(value);
    }

    public double pop() {
        return doubles.removeFirst();
    }

    public void add() {
        double popValue = this.pop();
        this.push(this.pop() + popValue);
    }

    public void sub() {
        double popValue = this.pop();
        this.push(this.pop() - popValue);
    }

    public void mul() {
        double popValue = this.pop();
        this.push(this.pop() * popValue);
    }

    public void div() {
        double popValue = this.pop();
        this.push(this.pop() / popValue);
    }

    public static void main(String[] args) {
        LinkedList<Double> doubles = new LinkedList<>(List.of(10.0, 34.45, 21.20, 15.0));
        StackCalc stackCalc = new StackCalc(doubles);

        stackCalc.push(99.99);
        System.out.println("push(): " + stackCalc.getDoubles());

        stackCalc.pop();
        System.out.println("pop() : " + stackCalc.getDoubles());

        stackCalc.add();
        System.out.println("add() : " + stackCalc.getDoubles());

        stackCalc.sub();
        System.out.println("sub() : " + stackCalc.getDoubles());

        stackCalc.push(100.00);
        stackCalc.push(2.00);
        System.out.println("***() : " + stackCalc.getDoubles());

        stackCalc.mul();
        System.out.println("mul() : " + stackCalc.getDoubles());

        stackCalc.div();
        System.out.println("div() : " + stackCalc.getDoubles());

    }
}
