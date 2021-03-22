package lesson8.part3;
// Answer_part3
    public class Person {
        public static class Child1 {
            public static String hello() {
                return "привет";
            }
        }

        public class Child2 {
            public String hello() {
                return "servus";
            }
        }
    }

    /*
1. Правильный ответ:
Разновидность внутреннего класса, располагается внутри любого метода → локальный класс,
Располагается внутри какого-либо класса и не содержит модификатор static → внутренний класс,
Разновидность локального класса, но существует сам по себе, без переменной → анонимный класс,
Располагается внутри какого-либо класса и содержит модификатор static → вложенный класс

3. Правильный ответ:
public class Person {
class SaveRec {
           ....
  → Внутри класса Person можно написать newPerson().new SaveRec();,

*public static class Animal {
public class SaveRec {
           ....
  → Так написать нельзя, компилятор выдаст ошибку,

public class Animal {
public class SaveRec {
           ....
  → Снаружи класса Animal можно написать new Animal().new SaveRec();,

public class Animal {
public static class SaveRec {
           ....
  → Снаружи класса Animal можно написать new Animal.SaveRec();,

public class Person {
static class SaveRec {
           ....
  → Внутри класса Person можно написать new SaveRec();
     */
