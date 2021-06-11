package lesson11.part1;
/*
Изящное решение с применением try-with-resources.
Никаких потерянных исключений.
Пример 2.
 */

import java.io.IOException;

public class SuppressedTryWithResources2 {
    public static void doAlwaysExceptions() throws IOException {
        try (AlwaysExceptions ae1 = new AlwaysExceptions(1);
             AlwaysExceptions ae2 = new AlwaysExceptions(2)) {
            ae1.method();
            ae2.method();
        }
    }
/*
При выходе из блока try закрываться (close()) исключения
будут в порядке - обратном к вызовам. (LIFO)
 */
    public static void main(String[] args) {
        try {
            doAlwaysExceptions();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            for (Throwable t : e.getSuppressed())
                System.out.println(t.getMessage() + " (подавленное)");
        }
    }
}
