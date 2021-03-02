package lesson6.part2;

public class StringCompare {
    static void myTest1() {
        System.out.println("* 1 *");
        String str1 = "12345";
        String str2 = "12345";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        System.out.println("* 2 *");
        String stringAsObject1 = new String("12345");
        String stringAsObject2 = new String("12345");
        System.out.println(stringAsObject1 == stringAsObject2);
        System.out.println(stringAsObject1.equals(stringAsObject2));

        System.out.println("* 3 *");
        str2 = "1234";
        str2 += "5";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

    }

    public static void main(String[] args) {
        myTest1();
    }
}
