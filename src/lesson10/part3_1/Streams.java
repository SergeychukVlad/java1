package lesson10.part3_1;

import java.io.PrintStream;

public class Streams {
    // пример смешивания потоков
    public static void main(String[] args) {
        System.out.println("Что такое System.out?");
        PrintStream printStream = System.out;
        for (int i = 0; i < 1000; i++) {
            printStream.println("Это");
            System.err.println("поток");
            printStream.println("для");
            System.err.println("стандартного");
            printStream.println("вывода");
        }
    }
}
