package lesson10.part2;

import java.util.Date;

public class ExceptionOrCompare {
    public static void main(String[] args) {
        Object oNull = null;
        long startTime = new Date().getTime();
        for (int i = 0; i < 1000000; i++) {
            if (oNull != null) {
                oNull.toString();
            }
        }
        System.out.println("Сравнение: " + (new Date().getTime() - startTime) + " mSec" + "\n");

        startTime = new Date().getTime();
        for (int i = 0; i < 1000000; i++) {
            try {
                oNull.toString();
            } catch (Exception e) {
            }
        }
        System.out.println("Исключение: " + (new Date().getTime() - startTime) + " mSec" + "\n");
    }
}
