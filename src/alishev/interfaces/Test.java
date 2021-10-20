package alishev.interfaces;

public class Test {

    public static void outputInfo(Info info) {
        info.showInfo();
    }

    public static void main(String[] args) {
//        Person person1 = new Person("Alex");
//        Animal animal1 = new Animal(1);
//
//        person1.sayHallo();
//        animal1.sleep();
//
//        person1.showInfo();
//        animal1.showInfo();

        Info info1 = new Animal(1);
        Info info2 = new Animal(2);
        Animal animal1 = new Animal(55);

        Info info3 = new Person("Bob");
        Info info4 = new Person("Alex");
        Person person1 = new Person("Tim");

        info1.showInfo();
        info2.showInfo();
        info3.showInfo();
        info4.showInfo();

        outputInfo(animal1);
        outputInfo(person1);
    }

}
