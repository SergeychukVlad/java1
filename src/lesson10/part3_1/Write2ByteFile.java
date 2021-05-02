package lesson10.part3_1;

import java.io.FileOutputStream;
import java.io.IOException;

public class Write2ByteFile {
    public static void main(String[] args) {
        try {
            // as Writer
            FileOutputStream byteFile = new FileOutputStream("file1.bin");
            try {
                for (byte b = 0; b < 127 ; b++) {
                    byteFile.write(b);
                }
            } finally {
                byteFile.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
