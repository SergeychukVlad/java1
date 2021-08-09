package lesson6.part2;

public class IntegerCompare {
    static void myTest1() {
        System.out.println("* 1 *");
        Integer intAsObject1 = 5;
        Integer intAsObject2 = 5;
        System.out.println(intAsObject1 == intAsObject2);
        System.out.println(intAsObject1.equals(intAsObject2));
    }

    public static void main(String[] args) {
        myTest1();
    }
}
