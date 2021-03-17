package lesson8.part1;

public class HashCode {

    static void myTest() {
        System.out.println("Hash-code for new Object(): ");
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());

        System.out.println("Hash-code for new Integer(5): ");
        System.out.println(new Integer(5).hashCode());
        System.out.println(new Integer(5).hashCode());
        System.out.println(new Integer(5).hashCode());

        System.out.println("Hash-code for new String(\"My String\"): ");
        System.out.println(new String("My String").hashCode());
        System.out.println(new String("My String").hashCode());
        System.out.println(new String("My String").hashCode());
    }
/*
Строки, имеющие не уникальный hashCode
 */
    static void stringCollisions() {
        String[] collisionsString = {
                "pollinating sandboxes",
                "amusement & hemophilias",
                "schoolworks = perversive",
                "electrolysissweeteners.net",
                "Microcomputers: the unredeemed lollipop..."};
        for (String s : collisionsString) {
            System.out.println(s.hashCode());
        }
    }

    public static void main(String[] args) {
        myTest();
        stringCollisions();
    }
}
