package lesson10.part3_2;

import java.io.*;

public class InputStreamReaderInAction {

    public static void one() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("source.txt"));
        int x = 0;
        while (x != -1) {
            x = reader.read();
            System.out.println(x);
        }
    }

    public static void two() throws IOException {
        char[] code = new char[65536];
        BufferedWriter logWriter = new BufferedWriter(new FileWriter("coder.log"));
        BufferedReader reader = new BufferedReader(new FileReader("source1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("coded.txt"));
        try {
            for (int symbol; (symbol = reader.read()) >= 0; ) {
                code[symbol] = (char) symbol;
            }
            writer.write(code);
        } catch (Exception e) {
            logWriter.write(e.getMessage());
        } finally {
            reader.close();
            writer.close();
            logWriter.close();
        }
    }

    public static void main(String[] args) throws IOException {
        two();
    }
}
