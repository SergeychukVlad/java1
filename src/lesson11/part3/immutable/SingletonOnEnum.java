/*
Правильный Singleton в Java
Вариант - NOT LAZY. Enum Singleton.

+ Остроумно
+ Сериализация из коробки
+ Потокобезопасность из коробки
+ Возможность использования EnumSet, EnumMap и т.д.
+ Поддержка switch
- Не ленивая инициализация
 */
package lesson11.part3.immutable;

public class SingletonOnEnum {
    public enum Singleton {
        INSTANCE;
    }
}
