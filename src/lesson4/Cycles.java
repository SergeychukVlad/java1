package lesson4;

public class Cycles {
//    http://espressocode.top/get-name-of-current-method-being-executed-in-java/

    static void cycleWhile() {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        int i = 0;
        while (i < 5) {
            i++;
            System.out.println("выводится строка № " + i);
            if (i == 3) {
                System.out.println("А здесь - continue! И программа движется дальше.");
                continue;
            }
        }
        System.out.println();
    }

    static void cycleDoWhile() {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        int i = 0;
        do {
            i++;
            System.out.println("выводится строка № " + i);
            if (i == 2) {
                System.out.println("А здесь - break! И программа останавливается в этой точке!");
                break;
            }
        } while (i < 5);
        System.out.println();
    }

    static void cycleFor() {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("выводится строка № " + i);
        }
        System.out.println();
    }

    static void cycleInfinity1() {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        while (true) {
            System.out.println("выводиться строка будет бесконечно...");
        }
    }

    static void cycleInfinity2() {
        System.out.println("---------------- " + new Throwable().getStackTrace()[0].getMethodName() + " ----------------");
        for (; ; ) {
            System.out.println("выводиться строка будет бесконечно...");
        }
    }

    public static void main(String[] args) {
        cycleWhile();
        cycleDoWhile();
        cycleFor();
        cycleInfinity1();
        cycleInfinity2();
    }
}
