package lesson6.part2;

public class CompareToInteger {
    public static void main(String[] args) {
        Integer a = 2;
        Integer b = 10;
        System.out.println(a.compareTo(b));

        a += 10;
        System.out.println(a.compareTo(b));

        a -= 2;
        System.out.println(a.compareTo(b));
    }
}
