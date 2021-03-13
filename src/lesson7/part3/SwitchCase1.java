package lesson7.part3;

public class SwitchCase1 {

    static void myTestNoBreak(int value) {
        switch (value) {
            case 1:
                System.out.println("this is case " + 1);
            case 2:
                System.out.println("this is case " + 2);
            case 3:
                System.out.println("this is case " + 3);
            case 4:
                System.out.println("this is case " + 4);
            case 5:
                System.out.println("this is case " + 5);
            default:
                System.out.println("this is case default");
        }
        System.out.println();
    }

    static void myTestWithBreak(int value) {
        switch (value) {
            case 1:
                System.out.println("this is case " + 1);
                break;
            case 2:
                System.out.println("this is case " + 2);
                break;
            case 3:
                System.out.println("this is case " + 3);
                break;
            case 4:
                System.out.println("this is case " + 4);
                break;
            case 5:
                System.out.println("this is case " + 5);
                break;
            default:
                System.out.println("this is case default");
        }
        System.out.println();
    }

   static void myTestGroupWithBreak(int value) {
        switch (value) {
            case 1:
                System.out.println("this is case " + 1);
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("this is case 2, 3, 4");
                break;
            case 5:
                System.out.println("this is case " + 5);
                break;
            default:
                System.out.println("this is case default");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        myTestNoBreak(5);
        myTestNoBreak(3);
        myTestWithBreak(5);
        myTestWithBreak(3);
        myTestGroupWithBreak(3);
    }
}
