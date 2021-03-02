package lesson6.part2;

public class ObjectsCompare {
    static void myTest1() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println(obj1 == obj2);
        System.out.println(obj1.equals(obj2));
        obj2 = obj1;
        System.out.println(obj1 == obj2);
        System.out.println(obj1.equals(obj2));
    }

    public static void main(String[] args) {
        myTest1();
    }
}
