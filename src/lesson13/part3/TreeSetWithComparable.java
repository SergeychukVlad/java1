package lesson13.part3;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetWithComparable {
    public static class GeoPoint implements Comparable<GeoPoint> {
        double lat = 0;
        double lon = 0;

        public GeoPoint(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }

        @Override
        public int compareTo(GeoPoint o) {
            return Double.compare(dist2Zero(lat, lon), dist2Zero(o.lat, o.lon));
        }

        @Override
        public String toString() {
            return "GeoPoint{" +
                    "lat=" + lat +
                    ", lon=" + lon +
                    '}';
        }

        public static double dist2Zero(double lat, double lon) {
            return 111.111 * Math.sqrt(lon * lon + lat * Math.cos(Math.PI * lon / 180) * lat + Math.cos(Math.PI * lon / 180));
        }

        public static void main(String[] args) {
            TreeSet<GeoPoint> treeSet = new TreeSet<>(new Comparator<GeoPoint>() {
                @Override
                public int compare(GeoPoint o1, GeoPoint o2) {
                    return Double.compare(o1.lat, o2.lat);
                }
            });
            treeSet.add(new GeoPoint(53.4566, 107.2045));   // Иликта
            treeSet.add(new GeoPoint(43.1738, 131.8957));   // Владивосток
            treeSet.add(new GeoPoint(54.9696, 82.6692));    // Новосибирск

            System.out.println(treeSet);
            System.out.println(treeSet.descendingSet());    // обратная сортировка
        }
    }
}
