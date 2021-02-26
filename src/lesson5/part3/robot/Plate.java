package lesson5.part3.robot;

public class Plate {
    int id;
    Position position;
    double volume = 1000.0;  // max Volume, mL

    public Plate(int id) {
        this.id = id;
    }

//    boolean isEmpty(){
//        return Detector.plateIsEmpty(id);
//    }
}
