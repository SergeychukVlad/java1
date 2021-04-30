package lesson10.part1;

public class FewExceptionsInOne {

    static void finallyExample() {
        System.out.println();
        try {
            System.out.println("try - ");
        } catch (Exception e) {
            System.out.println("catch - ");
        } finally {
            System.out.println("finally -");
        }
    }

    static void finallyCatchExample() {
        System.out.println();
        try {
            System.out.println("try - ");
            int ex = 1 / 0;
        } catch (Exception e) {
            System.out.println("catch - ");
        } finally {
            System.out.println("finally -");
        }
    }

    static int finallyResearch1() {
        /*
Пример того, как работает finally.
Finally отработает в любом случае. А потом в try return вернет 1.
         */
        System.out.println();
        try {
            System.out.println("try - ");
            return 1;
        } catch (Exception e) {
            System.out.println("catch - ");
            return 2;
        } finally {
            System.out.println("finally -");
        }
    }

    static int finallyResearch2() {
        /*
Пример того, как работает finally.
Finally отработает в любом случае. И из себя сделает return 3.
         */
        System.out.println();
        try {
            System.out.println("try - ");
            return 1;
        } catch (Exception e) {
            System.out.println("catch - ");
            return 2;
        } finally {
            System.out.println("finally -");
            return 3;
        }
    }

    static int finallyResearch3() {
        /*
Пример того, как работает finally.
В try будет исключение.
Идём в catch. Там не выходим по return, потому что Finally отработает в любом случае.
И из себя сделает return 3.
         */
        System.out.println();
        try {
            System.out.println("try - ");
            int ex = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("catch - ");
            return 2;
        } finally {
            System.out.println("finally -");
            return 3;
        }
    }

    public static Integer sqr(Integer n) {
        try {
            return n * n;
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("try");
            System.out.println((new int[5])[5]);
            int ex = 1 / 0;
            ((Object) null).toString();
        } catch (ArithmeticException e) {
            System.out.println("Произошло деление на ноль");
        } catch (NullPointerException e) {
            System.out.println("Обращение к объекту по ссылке null");
        } catch (IndexOutOfBoundsException | NegativeArraySizeException e) {
            System.out.println("IndexOutOfBoundsException или NegativeArraySizeException");
            System.out.println(e.getMessage());
            System.out.println(e);
        }
        finallyExample();
        finallyCatchExample();
        System.out.println(finallyResearch1());
        System.out.println(finallyResearch2());
        System.out.println(finallyResearch3());
        System.out.println(sqr(null));
        System.out.println(sqr(5));
    }
}
