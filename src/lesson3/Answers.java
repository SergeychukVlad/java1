package lesson3;

import java.util.Arrays;
import java.util.List;

public class Answers {
    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(1.78, 5.26, 100.234);
        for (Double number : numbers) {
            System.out.println(fractional(number));
        }
    }

    static double fractional(double num) {
        return num % 1;
    }
}
