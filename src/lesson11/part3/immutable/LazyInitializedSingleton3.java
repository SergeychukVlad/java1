/*
Правильный Singleton в Java
Вариант - LAZY. On Demand Holder idiom.

+ Ленивая инициализация
+ Высокая производительность
- Невозможно использовать для не статических полей класса

Summary
Можно выделить следующие короткие советы по использованию того или иного подхода для реализации шаблона “Одиночка”.

1) Использовать нормальную (не ленивую) инициализацию везде, где это возможно;
2) Для статических полей использовать On Demand Holder idiom;
3) Для простых полей использовать Double Checked Lock & volatile idiom;
4) Во всех остальных случаях использовать Synchronized accessor;

 */
package lesson11.part3.immutable;

public class LazyInitializedSingleton3 {
    public static class SingletonHolder {
        public static final LazyInitializedSingleton3 HOLDER_INSTANCE = new LazyInitializedSingleton3();

        public static LazyInitializedSingleton3 getInstance() {
            return SingletonHolder.HOLDER_INSTANCE;
        }
    }
}
