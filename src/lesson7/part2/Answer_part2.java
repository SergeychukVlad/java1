package lesson7.part2;

public class Answer_part2 {
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
        System.out.println(myAnswerTest((byte) 10));
        System.out.println(myAnswerTest((byte) 0b0100101));
        System.out.println(myAnswerTest((byte) 0b1000100));
    }
}
