package lesson6.part1;

public class Answer_part1 {
    public static int sumArrayItems(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {1, 4, 5, 6, 8};
        System.out.println(sumArrayItems(ints));
    }
/*
Пункт 2. Правильные ответы:
1.  int a[];

2.  int []a = new int[10];

3.  int []a = {10, 26, 12, 35};

4.  int a[] = {11, 22, 33};
    int item = a[1];

5.  int a[][][];

6.  int a1[], a2[], a3[];
    int a[][] = {a1, a2, a3};

7.  int a[][];
    int item = a[1][2];
*/
}
