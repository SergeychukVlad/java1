package lesson6.part2;

public class CompareToString {
    private static void myTest1() {
        String a = "ABCDE12345";
        String b = "ABCDE12345";
        System.out.println(a.compareTo(b));

        a = "aBCDE12345";
        System.out.println(a.compareTo(b));

        a = "ABCDE12345";
        b = "CDE12345";
        System.out.println(a.compareTo(b));
    }
// compareTo() для возвращения длины строки.
    private static void myTest2() {
        String a = "ABCDE12345";
        System.out.println(a.compareTo(""));
        System.out.println("".compareTo(a));
        System.out.println(a.length());
    }

    public static void main(String[] args) {
        myTest1();
        myTest2();
    }
/*
1. Для проверки объектов на равенство удобно использовать метод equals()
2. Для сравнения объектов ОДНОГО типа на больше/меньше удобно использовать compareTo(), если он реализован
(объекты А и В равны - вернёт 0, А > B - вернёт положительное число, A < B - вернёт отрицательное)
3. Для классов-обёрток, а также для String, compareTo() реализован
 */
}
