package lesson7.part3;

public class Answer_part3 {
    enum Grade {
        VERYBAD,
        BAD,
        SATISFACTORILY,
        GOOD,
        EXCELLENT,
        NOTDEFINED
    }

    static void myTest() {
        int i = 1;
        switch (i) {
            case 1:
                System.out.print("1");
            case 2:
                System.out.print("2");
                break;
            default:
                System.out.print("3");
        }
    }

    static Grade intToGrade(int grade) {
        switch (grade) {
            case 1:
                return Grade.VERYBAD;
            case 2:
                return Grade.BAD;
            case 3:
                return Grade.SATISFACTORILY;
            case 4:
                return Grade.GOOD;
            case 5:
                return Grade.EXCELLENT;
            default:
                return Grade.NOTDEFINED;
        }
    }

    public static void main(String[] args) {
        myTest();
        intToGrade(5);
        intToGrade(9);
        intToGrade(1);
    }
}
