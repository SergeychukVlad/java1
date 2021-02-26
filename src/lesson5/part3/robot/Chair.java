package lesson5.part3.robot;

import lesson5.part1.Person;

public class Chair {
    int id;
    Position position;
    double radius = 0.25;  // meter
    Person person;
    Plate plate;

    public Chair(int id) {
        this.id = id;
    }

    boolean inArea(Position otherPosition) {
        return position.inRadius(otherPosition, radius);
    }

//    boolean isEmpty(){
//        return Detector.chairIsEmpty(id);
//    }

}
