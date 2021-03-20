package lesson8.part3;

public class ClassWithStaticVar {
    static String staticString;

    public static void main(String[] args) {
        myTest1();
        myTest2();
    }

    private static void myTest1() {
        ClassWithStaticVar a = new ClassWithStaticVar();
        a.staticString = "Переменная я статическая, и хранюсь в одном месте, фактически!";
        System.out.println(a.staticString); // выводим a.staticString

        ClassWithStaticVar b = new ClassWithStaticVar();
        b.staticString = "В одном месте?... Доверяем! Но ... - проверяем!";
        System.out.println(a.staticString); // снова выводим a.staticString
    }

    private static void myTest2() {
        ClassWithStaticVar a = new ClassWithStaticVar();
        ClassWithStaticVar.staticString = "Переменная я статическая, и хранюсь в одном месте, фактически!";
        System.out.println(ClassWithStaticVar.staticString); // выводим a.staticString

        ClassWithStaticVar b = new ClassWithStaticVar();
        ClassWithStaticVar.staticString = "В одном месте?... Доверяем! Но ... - проверяем!";
        System.out.println(ClassWithStaticVar.staticString); // снова выводим a.staticString
    }
}