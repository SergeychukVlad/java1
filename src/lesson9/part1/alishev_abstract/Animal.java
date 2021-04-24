package lesson9.part1.alishev_abstract;
/*
Абстрактный класс - это то, чем данный объект является.
Это - класс, с заданным уже поведением. И мы соглашаемся с этим поведением.
 */
public abstract class Animal {
    public void eat(){
        System.out.println("I am eating...");
    }

    public abstract void makeSound();
}
