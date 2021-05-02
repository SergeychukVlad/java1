package lesson10.part3_1;

import java.io.FileOutputStream;
import java.io.IOException;

public class Write2ByteFileViaArray {
    public static void main(String[] args) {
        byte[] bytes = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        try {
            // as Writer
            FileOutputStream byteFile = new FileOutputStream("file1.bin");
            try {
                byteFile.write(bytes);
            } finally {
                byteFile.close();
            }
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
