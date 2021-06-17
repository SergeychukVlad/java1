/*
Правильный Singleton в Java
Вариант - LAZY. Double Checked Locking & volatile.

+ Ленивая инициализация
+ Высокая производительность
- Поддерживается только с JDK 1.5
 */
package lesson11.part3.immutable;

public class LazyInitializedSingleton2 {
    private static volatile LazyInitializedSingleton2 instance;

    public static LazyInitializedSingleton2 getInstance() {
        LazyInitializedSingleton2 localInstance = instance;
        if (localInstance == null) {
            synchronized (LazyInitializedSingleton2.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new LazyInitializedSingleton2();
                }
            }
        }
        return localInstance;
    }
}
