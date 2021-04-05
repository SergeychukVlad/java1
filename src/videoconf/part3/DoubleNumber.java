package videoconf.part3;

public class DoubleNumber extends Number {
    double num;

    public DoubleNumber(double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
