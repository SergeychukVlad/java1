package lesson4;

public class Answers_part1 {
    public static void main(String[] args) {
        System.out.println(addAsStrings(2, 1));
        System.out.println(addAsStrings(1, 5));
    }

    static int addAsStrings(int n1, int n2) {
        return Integer.parseInt(n1 + String.valueOf(n2));
    }
}
