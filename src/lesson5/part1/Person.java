package lesson5.part1;

public class Person {
    private String name;
    private int age;
    private String country;

    public Person() {
        country = "RU";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return "RU";
    }
}
