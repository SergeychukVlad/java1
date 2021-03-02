package lesson6.part3;

import java.util.Arrays;

public class Answer_part3 {
    static void myTest1() {
        int[] a1 = {1, 1, 1, 1, 3};
        int[] a2 = new int[5];
        Arrays.fill(a2, 1);
        a2[4] = 3;
        System.out.println(Arrays.equals(a1, a2));
    }

    static void myTest2() {
        int[] a1 = {12, 5, 0, 58, 36};
        int[] a2 = Arrays.copyOf(a1, a1.length);
        a2[2] = 0;
        System.out.println(Arrays.equals(a1, a2));
    }

    static void myTest3() {
        int[] a1 = {12, 5, 0, 58, 36};
        int[] a2 = Arrays.copyOf(a1, a1.length);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a1, a2));
    }

    public static int arrayMax(int[] a) {
        if(a.length ==0) {
            return 0;
        } else {
            Arrays.sort(a);
            return a[a.length - 1];
        }
    }

    public static void main(String[] args) {
        myTest1();
        myTest2();
        myTest3();

        int[] a1 = {12, 5, 0, 58, 36};
        System.out.println(arrayMax(a1));

        int[] a2 = {};
        System.out.println(arrayMax(a2));
    }
}
