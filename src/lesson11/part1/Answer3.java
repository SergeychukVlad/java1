package lesson11.part1;

import java.io.IOException;

public class Answer3 {
    public void doSomething(int n) throws IOException {

    }

    public void test(int n) throws IOException {
        try {
            doSomething(n);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("finally executed");
        }
    }
}
