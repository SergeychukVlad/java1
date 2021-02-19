package lesson4;

public class LogicalOperatorsAndOperations {
    static void logicalBitOperationOrder() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 5;

        boolean result1 = a++ == b & ++c == --d;
        System.out.println("result1 = " + result1);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        boolean result2 = a == b & ++c == --d;
        System.out.println("result2 = " + result2);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }

   static void logicalOperationOrder() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 5;

        boolean result1 = a++ == b && ++c == --d;
        System.out.println("result1 = " + result1);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        boolean result2 = a == b && ++c == --d;
        System.out.println("result2 = " + result2);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
    }

    static void logicalOperatorsPriority() {
        System.out.println(false || false && true || true);
        System.out.println(false || (false && true) || true);
        System.out.println((false || false) && (true || true));

        System.out.println(!true && false);
        System.out.println((!true) && false);
        System.out.println(!(true && false));
    }

    static void logicalOperatorsCompare() {
        System.out.println("Результат 2*2 == 5 : " + (2 * 2 == 5));
        System.out.println("Результат 2*2 > 3  : " + (2 * 2 > 3));
        System.out.println("Результат 0 != 1   : " + (0 != 1));
        System.out.println("Результат (2*2 == 5 && 2*2 > 3) : " + (2 * 2 == 5 && 2 * 2 > 3));
        System.out.println("Результат (2*2 == 5 || 2*2 > 3) : " + (2 * 2 == 5 || 2 * 2 > 3));
        System.out.println("Результат 0 != 1 : " + (0 != 1));
        System.out.println("Результат !(0 != 1) : " + !(0 != 1));
    }

    static void logicalOperators(int x, int y) {
        System.out.println("Результат х > y : " + (x > y));
        System.out.println("Результат х < y : " + (x < y));
        System.out.println("Результат х == y: " + (x == y));
        System.out.println("Результат х >= y: " + (x >= y));
        System.out.println("Результат х <= y: " + (x <= y));
        System.out.println("Результат х != y: " + (x != y));
    }

    public static void main(String[] args) {
        logicalOperators(555, 999);
        System.out.println("----------------------------------------------------------");
        logicalOperatorsCompare();
        System.out.println("----------------------------------------------------------");
        logicalOperatorsPriority();
        System.out.println("----------------------------------------------------------");
        logicalOperationOrder();
        System.out.println("----------------------------------------------------------");
        logicalBitOperationOrder();
    }
}
