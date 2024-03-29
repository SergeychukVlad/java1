package lesson11.part3.immutable;
/*
Правильный Singleton в Java
Вариант - LAZY. Synchronized Accessor.
+ Ленивая инициализация
- Низкая производительность (критическая секция) в наиболее типичном доступе

Особенность реализации Singleton в Java за три шага
Поведение Одиночки на Java невозможно реализовать с помощью обычного конструктора, потому что конструктор всегда
возвращает новый объект. Поэтому все реализации Singleton’a сводятся к тому, чтобы скрыть конструктор
и создать публичный статический метод, который будет управлять существованием объекта-одиночкии «уничтожать» всех
вновь появляющихся экземпляров объекта.
В случае вызова Singleton’a он должен либо создать новый объект (если его еще нет в программе),
либо вернуть уже созданный.
 */

public class LazyInitializedSingleton1 {
    /*
    #1. Нужно добавить в класс приватное статическое поле, содержащее одиночный объект.
    #2. Сделать конструктор класса (конструктор по-умолчанию) приватным, (чтобы доступ к нему был закрыт
        за пределами класса, тогда он не сможет возвращать новые объекты).
    #3. Объявить статический создающий метод, который будет использоваться для получения одиночки:
     */
    private static LazyInitializedSingleton1 instance;                               // #1

    private LazyInitializedSingleton1() {}                                           // #2

    public static LazyInitializedSingleton1 getInstance() {                          // #3
        if (instance == null) {                                                     //если объект еще не создан
            instance = new LazyInitializedSingleton1();                              //создать новый объект
        }
        return instance;                                                            // вернуть ранее созданный объект
    }
}

/*
Ленивую инициализацию (Lazy Initialization) еще называют отложенной инициализацией.
Это прием в программировании, когда ресурсоемкая операция (а создание объекта – это ресурсоемкая операция) выполняется
по требованию, а не заблаговременно. Что в общем-то и происходит в нашем коде Singleton’a.
Другими словами, наш объект создается в момент обращения к нему, а не заранее.
Не следует полагать, что понятие ленивой инициализации как-то жестко связана именно с Singleton’ом.
Отложенная инициализация также используется и в других порождающих паттернах проектирования, например в таких как
Proxy (Заместитель) и Factory Method (Фабричный метод), но это тоже другая история =)
 */