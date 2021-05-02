package lesson10.part3_1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadCharFile {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("myFirstFile");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            String strFromFile = scanner.nextLine();
            System.out.println(strFromFile);
        }
        fileReader.close();
    }
}
