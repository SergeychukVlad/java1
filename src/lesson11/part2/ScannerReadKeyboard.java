package lesson11.part2;

import java.util.Scanner;

/*
Scanner. Чтение с клавиатуры
 */
public class ScannerReadKeyboard {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ваше имя: ");
            String firstName = scanner.nextLine();
            System.out.println("Ваше отчество: ");
            String middleName = scanner.nextLine();
            System.out.println("Ваша фамилия: ");
            String lastName = scanner.nextLine();
            System.out.println(firstName + " " + middleName + " " + lastName);
        }
    }
}
