package lesson11.part2;
/*
Создайте метод с сигнатурой public void scanLines(), который реализует следующий алгоритм:
- вводить с клавиатуры строки, до тех пор, пока во входной строке не встретится "/stop"
- если во входной строке содержится "Привет" вывести на консоль "Здравствуйте!"
- если во входной строке содержится "как дела" вывести на консоль "Хорошо"
- если во входной строке содержится "/stop" - закончить выполнение метода
- во всех остальных случая вывести введенную строку на консоль

Примечание: для проверки, содержит ли строка, содержимое другой строки используйте метод
класса String boolean contains(String str)
 */
import java.util.Scanner;

public class Answer3 {

    public static void scanLines() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str.contains("/stop")) return;
                else if (str.contains("как дела")) System.out.println("Хорошо");
                else if (str.contains("Привет")) System.out.println("Здравствуйте!");
                else System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {
        scanLines();
    }
}
