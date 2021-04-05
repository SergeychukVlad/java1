package videoconf.part3;

public class IntNumber extends Number {
    int num;

    public IntNumber(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
