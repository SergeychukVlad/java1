package lesson5.part3.robot;

public class Position {
    //    point coordinates
    double lat, lon;

    //    hint otherPosition into Circle with radius
    public boolean inRadius(Position otherPosition, double radius) {
        double latDiff = lat - otherPosition.lat;
        double lonDiff = lon - otherPosition.lon;
        return latDiff * latDiff + lonDiff * lonDiff <= radius;
    }

}
