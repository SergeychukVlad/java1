package lesson7.part3;

public class Examples {

    static void test2() {
        int a = 3;
        int b = 6;
        int c = a | b;
        int d = a & b;
        int d1 = a & b;
        int e = a ^ b;
        int f = ~b;
        int ff = b | 1;
        int f2 = ~ff;
        int f22 = f2 | 1;
        int f3 = f22 >>> 10;
        System.out.println("a = " + Integer.toBinaryString(a));
        System.out.println("b = " + Integer.toBinaryString(b));
        System.out.println("a | b = " + Integer.toBinaryString(c));
        System.out.println("a | b = " + Integer.toString(c, 2));
        System.out.println("a & b = " + Integer.toBinaryString(d));
        System.out.println("a & b >> 2 = " + Integer.toBinaryString(d1));
        System.out.println("a ^ b = " + Integer.toBinaryString(e));
        System.out.println("~ b = " + Integer.toBinaryString(f));
        System.out.println("b | 1 = " + Integer.toBinaryString(ff));
        System.out.println("~ ff = " + Integer.toBinaryString(f2));
        System.out.println("f2 | 1 = " + Integer.toBinaryString(f22));
        System.out.println("f22 >>> 10 " + Integer.toBinaryString(f3));
    }

    public static void main(String[] args) {
        test2();
    }
}
