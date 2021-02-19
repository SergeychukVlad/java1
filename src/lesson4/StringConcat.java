package lesson4;

public class StringConcat {
    public static void main(String[] args) {
        String str1 = "Соединяем строки ";
        String str2 = "плюсом легко, без мороки!";
        String str3 = "через concat, если хотим усложнить этот ряд...";

        String result1 = str1 + str2;
        String result2 = str1.concat(str3);

        str1 += str2;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(str1);

        System.out.println("Или " + str3);
    }
}
