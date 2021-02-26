package lesson5.part3;

public class Answers_part3 {
    public static void main(String[] args) {
        class Point2D {
            int x, y;

            Point2D(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return x + "," + y;
            }
        }

        class Point3D extends Point2D {
            int z;

            Point3D(int x, int y, int z) {
                super(x, y);
                this.z = z;
            }

            @Override
            public String toString() {
                return super.toString() + "," + z;
            }
        }
    }
}
