package lesson8.part2;

public class Goat implements Speaking, Eating {
    @Override
    public String eat() {
        return "Сено";
    }

    @Override
    public String say() {
        return "Мее";
    }
}
