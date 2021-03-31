package lesson8.part2;

public class Answer_part2 {
/*
1. Правильные ответы:
- невозможно создать экземпляр абстрактного класса,
- класс-наследник абстрактного класса либо сам должен быть абстрактным, либо реализовать все абстрактные методы,
- interface позволяет использовать унифицированный доступ к классам, не связанным иерархией наследования

2. Правильные ответы:
- public class Number implements Comparable {
...
} → этот класс обязан реализовать все методы из Comparable,

- public class Number implements ICompare {
...
} → можно написать ICompare i = new Number();,

public abstract class Number {
...
} → нельзя создать экземпляр этого класса,

public final class Number {
...
} → у этого класса не может быть потомков,

public abstract final class Number {
...
} → так нельзя, компилятор выдаст ошибку

 */

}
