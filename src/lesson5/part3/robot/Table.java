package lesson5.part3.robot;

public class Table {
    Position position;
    double radius = 0.75;  // meter

    Chair chair1;
    Chair chair2;
    Chair chair3;

    boolean inArea(Position otherPosition) {
        return position.inRadius(otherPosition, radius);
    }

}
