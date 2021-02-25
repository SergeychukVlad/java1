package lesson4;

public class Answers_part3 {
    static long factorial(long n) {
        long fValue = 1;
        if (n > 0) {
            int i = 1;
            while ( i <= n) {
                fValue = fValue * i;
                i++;
            }
        }
        return fValue;
    }

    public static void main(String[] args) {
        factorial(0);
        factorial(1);
        factorial(5);
        System.out.println(true || false);
        System.out.println(false || true);
    }
}
