package lesson11.part1;

import java.io.IOException;

public class SuppressedExceptions2 {
    public static void doAlwaysExceptions() throws IOException {
        AlwaysExceptions ae = new AlwaysExceptions(1);
        try {
            ae.method();
        } finally {
            ae.close();
        }
    }

    public static void main(String[] args) {
        try {
            doAlwaysExceptions();
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }
}
