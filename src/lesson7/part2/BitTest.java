package lesson7.part2;

public class BitTest {
    //    пример кодировки
    static void myCodeTest() {
        char key = 0b01001011_10001011;
        char c1 = 'A';
        char c2 = 'K';
        char c3 = 'M';

        System.out.print(c1);
        System.out.print(c2);
        System.out.println(c3);

//        c1 = c1 ^ key;
        c1 ^= key;
        c2 ^= key;
        c3 ^= key;

        System.out.print(c1);
        System.out.print(c2);
        System.out.println(c3);

        c1 ^= key;
        c2 ^= key;
        c3 ^= key;

        System.out.print(c1);
        System.out.print(c2);
        System.out.println(c3);
    }

    static void myTest() {
        byte unSignedSpeed = (byte) 0b10000111; // 135
        System.out.println(unSignedSpeed);
        int speed1 = unSignedSpeed;
        System.out.println(speed1);
        System.out.println(Integer.toBinaryString(speed1));

        int speed2 = unSignedSpeed & 0b00000000_00000000_11111111; // двоичный аналог 0xFF
        System.out.println(speed2);
        System.out.println(Integer.toBinaryString(speed2));
    }

    static int myAnswerTest(byte value) {
        int result;
        if ((value & 0b00000000_00000001) == 0) {
            result = 0;
        } else {
            result = 1;
        }
        return result;
    }

    public static void main(String[] args) {
        myCodeTest();
        myTest();
        System.out.println(myAnswerTest((byte) 10));
        System.out.println(myAnswerTest((byte) 0b0100101));
        System.out.println(myAnswerTest((byte) 0b1000100));
    }
}
