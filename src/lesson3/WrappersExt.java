package lesson3;

public class WrappersExt {
    public static void main(String[] args) {
        String str0 = "999";
        String str1 = "000555";
        String str2 = "999.555";

        Short aShort = Short.valueOf(str0);
        int int1 = Integer.valueOf(str1);
        int int2 = Integer.parseInt(str1);
        Double aDouble1 = Double.valueOf(str2);
        Double aDouble2 = Double.parseDouble(str2);

        System.out.println("aShort = " + aShort);
        System.out.println("int1 = " + int1);
        System.out.println("int2 = " + int2);
        System.out.println("aDouble1 = " + aDouble1);
        System.out.println("aDouble2 = " + aDouble2);
    }
}
