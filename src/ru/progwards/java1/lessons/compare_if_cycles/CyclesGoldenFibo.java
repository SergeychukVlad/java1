package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {

    //  Будет возвращать true, если число number содержит цифру digit. Через String.contains()
    public static boolean containsDigit_throughStringContains(int number, int digit) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        String strNumber = String.valueOf(number);
        String charDigit = String.valueOf(digit);
        System.out.println("Число " + strNumber + " содержит цифру " + charDigit + "? - " + strNumber.contains(charDigit) + "\n");
        return strNumber.contains(charDigit);
    }

    //  Будет возвращать true, если число number содержит цифру digit. Через ( /, % )
    public static boolean containsDigit(int number, int digit) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        int occurrence = 0;             // Счетчик вхождений цифры в число
        int resultMod = number % 10;
        int resultDec = number / 10;
        do {
            if (resultDec == digit || resultMod == digit) {
                occurrence++;
            }
            resultMod = resultDec % 10;
            resultDec = resultDec / 10;
        } while (resultDec > 0);

        if (occurrence > 0) {
            System.out.println("Число " + number + " содержит цифру " + digit + "\n" + "Количество вхождений - " + occurrence + "\n");
            return true;
        } else {
            System.out.println("Число " + number + " не содержит цифру " + digit + "\n");
            return false;
        }
    }

    //  Будет возвращать числа Фибоначчи это ряд чисел 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
    //  в котором первые два элемента равны 1, а каждый следующий равен сумме двух предыдущих
    public static int fiboNumber(int n) {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        int i = 1;
        int presiousFiboNumber = 0;
        int currentFiboNumber = 1;
        int resultFiboNumber = 0;
        for (; i <= n; i++) {
            if (i == 1) {
                resultFiboNumber = 1;
                System.out.print("номер числа - " + i + " , ");
                System.out.println("значение числа Фибоначчи - " + resultFiboNumber);
            } else {
                resultFiboNumber = currentFiboNumber + presiousFiboNumber;
                System.out.print("номер числа - " + i + " , ");
                System.out.println("значение числа Фибоначчи - " + resultFiboNumber);
                presiousFiboNumber = currentFiboNumber;
                currentFiboNumber = resultFiboNumber;
            }
        }
        System.out.println();
        return resultFiboNumber;
    }

    //  Будет возвращать true, если треугольник со сторонами a, b, c является Золотым.
    //  Критерии - должен быть равнобедренным
    //  и отношение ребра к основанию должно лежать между значениями 1.61703 и 1.61903
    public static boolean isGoldenTriangle(int a, int b, int c) {
        double goldRangeValue;
        Double sideAtoDouble = (double) a;
        Double sideBtoDouble = (double) b;
        Double sideCtoDouble = (double) c;
        if (a == b && a != c) {
            goldRangeValue = sideAtoDouble / sideCtoDouble;
        } else if (b == c && b != a) {
            goldRangeValue = sideBtoDouble / sideAtoDouble;
        } else {
            goldRangeValue = sideAtoDouble / sideBtoDouble;
        }
        return (goldRangeValue <= 1.61903 && goldRangeValue >= 1.61703);
    }

    static void checkGoldenTriangle() {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        for (int sideA = 1; sideA <= 100; sideA++) {
//            for (int sideB = sideA / 2 + 1; sideB <= 100; sideB++) {
//            так было у меня.
//            Сергей Алтунджи: "Тут можно так сделать цикл (int sideB = sideA + 1; sideB <= 100; sideB++)
//            Мы же знаем, что у золотого треугольника ребро больше основания."
//            следую...
            for (int sideB = sideA + 1; sideB <= 100; sideB++) {
                if (isGoldenTriangle(sideA, sideB, sideB)) {
                    System.out.println("Треугольник золотого сечения. Основание: " + sideA + ". Ребро: " + sideB);
                }
            }
        }

    }

    static void myTesting() {
        containsDigit_throughStringContains(152, 9);
        containsDigit_throughStringContains(1452, 4);

        containsDigit(1156761196, 6);
        containsDigit(1156761196, 1);
        containsDigit(9856754, 1);
        containsDigit(9856754, 5);

        fiboNumber(15);

        checkGoldenTriangle();
    }

    public static void main(String[] args) {
        myTesting();
    }
}
