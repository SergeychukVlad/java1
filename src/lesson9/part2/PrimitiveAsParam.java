package lesson9.part2;

public class PrimitiveAsParam {
    static void primAsParam(int i) {
        i = 555;
        System.out.println("primAsParam i = " + i);
    }

    public static void main(String[] args) {
        int i = 999;
        System.out.println("main before i = " + i);
        primAsParam(i);
        System.out.println("main after i = " + i);
    }
}
