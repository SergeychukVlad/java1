package lesson9.part2;

import java.util.Arrays;

public class ObjectAsParam {
    static class Simple {
        int a;      // 0, as default
        boolean b;  // false, as default
        String msg = "Это класс Simple";

        @Override
        public String toString() {
            return "Simple{" +
                    "a=" + a +
                    ", b=" + b +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }

    static void objectAsParam1(Simple simple) {
        simple.a = 77777;
        simple.b = true;
        simple.msg = "Это - класс Simple. Метод objectAsParam1";
    }

    static void objectAsParam2(Simple simple) {
        simple = new Simple();
        simple.a = 55555;
        simple.b = true;
        simple.msg = "Сообщение изменено в objectAsParam2";
    }

    static void stringAsParam(String str) {
        str = "строка изменена в методе stringAsParam()";
        System.out.println(str);
    }

    static void arrayAsParam(int[] intArray) {
        intArray[0] = 2019;
    }

    static void arrayStrAsParam(String[] strArray) {
        strArray[0] = "2019";
    }

    public static void main(String[] args) {
        Simple simple = new Simple();
        System.out.println(simple);
        objectAsParam1(simple);
        System.out.println(simple);
        objectAsParam2(simple);
        System.out.println(simple);
        System.out.println("---------------");

        String str = "строка проинищиализирована в main()";
        System.out.println(str);
        stringAsParam(str);
        System.out.println(str);
        System.out.println("---------------");

        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(intArray));
        arrayAsParam(intArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println("---------------");

        String[] strArray = {"строка1", "строка2", "строка3", "строка4", "строка5"};
        System.out.println(Arrays.toString(strArray));
        arrayStrAsParam(strArray);
        System.out.println(Arrays.toString(strArray));
        System.out.println("---------------");
    }
}
