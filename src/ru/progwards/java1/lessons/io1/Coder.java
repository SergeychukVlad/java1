/*
Создать статический метод public static void codeFile(String inFileName, String outFileName, char[] code, String logName),
в котором прочитать файл inFileName и перекодировать его посимвольно в соответствии с заданным шифром,
результат записать в outFileName. Шифр задается маcсивом char[] code, где каждому символу symbol оригинального файла
соответствует символ code[(int)symbol] выходного файла.
В случае ошибок, в файл с именем logName вывести название ошибки через метод класса Exception - getMessage()
*/
package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coder {
    private static String logMessage = "Нет файла с таким именем на устройстве!";
    private static List<Character> chars = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        char[] code = new char[65536];
        String inFileName, outFileName, logName, decodedFileName;
        inFileName = "source.txt";
        outFileName = "coded.txt";
        decodedFileName = "decoded.txt";
        logName = "coder.log";

        codeFile(inFileName, outFileName, code, logName);
        decodeFile(outFileName, decodedFileName, code);
        System.setOut(System.out);
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        if (logName != null) {
            try {
                System.setOut(new PrintStream(new FileOutputStream(logName)));
                System.out.println("Здесь логи для класса Coder\n");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (outFileName != null) {
            try {
                FileOutputStream writer = new FileOutputStream(outFileName);
                if (inFileName != null) {
                    try {
                        FileInputStream reader = new FileInputStream(inFileName);
                        try {
                            while (reader.available() > 0) {
                                int symbol = reader.read();
                                code[symbol] = (char) symbol;
                                System.out.println(symbol);
                                writer.write(symbol);
//                                writer.write(Character.getNumericValue(symbol));
                            }
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            reader.close();
                            writer.close();
                        }
                    } catch (IOException e) {
                        System.out.println(logMessage);
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println(logMessage);
                System.out.println(e.getMessage());
            }
        }
    }

    public static void decodeFile(String outFileName, String decodedFileName, char[] code) {
        if (decodedFileName != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(outFileName));
                BufferedWriter writer = new BufferedWriter(new FileWriter(decodedFileName));
                try {
                    for (int symbol; (symbol = reader.read()) >= 0; ) {
                        char ch = code[(char) symbol];
                        writer.write(ch);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } finally {
                    reader.close();
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println(logMessage);
                System.out.println(e.getMessage());
            }
        }
    }
}

