package videoconf.part3;

public class Test {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Number num;
        IntNumber inum = new IntNumber(2);
        num = inum;
        DoubleNumber dnum = new DoubleNumber(3.5);

        print(num);
        print(dnum);
    }

    static void print(Number num) {
        System.out.println(num.getClass().getName());
        System.out.println(num);
    }
}
