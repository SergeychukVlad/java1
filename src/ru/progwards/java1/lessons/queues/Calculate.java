/*
Class Calculate, который содержит методы:

3.7 public static double calculation1(), возвращающую результат вычисления следующей формулы:
2.2*(3+12.1), используя класс StackCalc

3.8 public static double calculation2(), возвращающую результат вычисления следующей формулы:
(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)), используя класс StackCalc

 */
package ru.progwards.java1.lessons.queues;

public class Calculate {

    public static double calculation1() {
        StackCalc stackCalc = new StackCalc();

        stackCalc.push(3.0);
        stackCalc.push(12.1);
        stackCalc.add();                    // (3+12.1)
        stackCalc.push(2.2);
        stackCalc.mul();                    // 2.2*(3+12.1)

        return stackCalc.pop();
    }


    public static double calculation2() {
        StackCalc stackCalc = new StackCalc();

        stackCalc.push(737.22);
        stackCalc.push(24.0);
        stackCalc.add();
        double braces1_value = stackCalc.pop();     // (737.22+24)

        stackCalc.push(55.6);
        stackCalc.push(12.1);
        stackCalc.sub();
        double braces2_value = stackCalc.pop();     // (55.6-12.1)

        stackCalc.push(braces1_value);
        stackCalc.push(braces2_value);
        stackCalc.div();
        double left_part = stackCalc.pop();         // (737.22+24)/(55.6-12.1)

        stackCalc.push(19.0);
        stackCalc.push(3.33);
        stackCalc.sub();
        braces1_value = stackCalc.pop();            // (19-3.33)

        stackCalc.push(13.001);
        stackCalc.push(9.2);
        stackCalc.sub();
        stackCalc.push(stackCalc.pop());            // (13.001-9.2)

        stackCalc.push(2.0);
        stackCalc.mul();
        stackCalc.push(87.0);
        stackCalc.add();
        stackCalc.push(braces1_value);              // (87+2*(13.001-9.2))

        stackCalc.mul();                            // (19-3.33)*(87+2*(13.001-9.2))

        stackCalc.push(left_part);
        stackCalc.add();

        return stackCalc.pop();                     // (737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2))
    }


    public static void main(String[] args) {
        System.out.println((2.2 * (3 + 12.1) == calculation1()));
        System.out.println(((737.22 + 24) / (55.6 - 12.1) + (19 - 3.33) * (87 + 2 * (13.001 - 9.2)) == calculation2()));
    }

}
