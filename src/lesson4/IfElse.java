package lesson4;

public class IfElse {
    static void partOne() {
        if (2 * 2 == 5) System.out.println("Оказывается 2 * 2 равно 5!");
        if (2 * 2 == 4)
            System.out.println("Всё-таки 2 * 2 равно 4");
        else
            System.out.println("Действительно, 2 * 2 не равно 4 ...");

        if (2 * 2 < 0)
            System.out.println("2 * 2 - это отрицательное число!");
        else if (2 * 2 > 0)
            System.out.println("2 * 2 - это положительное число");
        else
            System.out.println("2 * 2 - это и есть ноль!");
    }

    static void partTwo(int x) {
        String daysString;
        String remainderInfo = "Число оканчивается на ";
        int remainder100 = x % 100;
        if (remainder100 >= 11 && remainder100 <= 20) {
            daysString = "дней";
            remainderInfo += remainder100;
        } else {
            int remainder10 = x % 10;
            if (remainder10 == 1)
                daysString = "день";
            else if (remainder10 >= 2 && remainder10 <= 4)
                daysString = "дня";
            else daysString = "дней";
            remainderInfo += remainder10;
        }
        System.out.println("Событие наступит через " + x + " " + daysString);
        System.out.println(remainderInfo);
    }

    public static void main(String[] args) {
        partOne();
        System.out.println("--------------------------------------------------");
        partTwo(128);
    }
}
