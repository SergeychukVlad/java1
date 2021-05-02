package lesson10.part3_1;

import java.io.FileWriter;
import java.io.IOException;

public class Write2CharFile {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("myFirstFile");
        fileWriter.write("Этот файл создан мной. \n");
        fileWriter.write("Теперь он будет жить на диске. \n");
        fileWriter.write("Или на флэшке. \n");
        fileWriter.close();
    }
}
