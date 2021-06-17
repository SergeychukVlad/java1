/*
Правильный Singleton в Java
Вариант - NOT LAZY. Static field.

+ Простая и прозрачная реализация
+ Потокобезопасность
- Не ленивая инициализация
 */
package lesson11.part3.immutable;

public class Singleton {
    public static final Singleton INSTANCE = new Singleton();


}
