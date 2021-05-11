package lesson10.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FromFile2StringArray {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("source.txt"));
        String str = input.next();
        char[] ch = str.toCharArray();
        System.out.println(ch);
    }
}
