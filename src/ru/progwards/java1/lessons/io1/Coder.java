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
import java.util.Scanner;

public class Coder {
    private static final String logMessage = "Нет файла с таким именем на устройстве!";

    public static void main(String[] args) throws IOException {
        char[] code = new char[65536];
        String inFileName, outFileName, logName, decodedFileName;
        inFileName = "source.txt";
        outFileName = "coded.txt";
        decodedFileName = "decoded.txt";
        logName = "coder.log";

        codeFile(inFileName, outFileName, code, logName);
        decodeFile(inFileName, outFileName, decodedFileName, code);
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
                FileWriter writer = new FileWriter(outFileName);
                if (inFileName != null) {
                    try {
                        FileReader reader = new FileReader(inFileName);
                        try {
                            int symbol;
                            while (true) {
                                symbol = reader.read();
                                if (symbol >= 0) {
                                    code[symbol] = (char) symbol;
                                    if (reader.ready()) {
                                        writer.write(symbol + System.getProperty("line.separator"));
                                    } else {
                                        writer.write(symbol + "");
                                        break;
                                    }
                                }
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

    public static void decodeFile(String inFileName, String outFileName, String decodedFileName, char[] code) {
        if (decodedFileName != null) {
            try {
                Scanner scanner = new Scanner(new File(outFileName));
                FileWriter writer = new FileWriter(decodedFileName);
                try {
                    while (scanner.hasNextLine()) {
                        writer.write(code[Integer.parseInt(scanner.nextLine())]);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } finally {
                    scanner.close();
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println(logMessage);
                System.out.println(e.getMessage());
            }
        }
        System.out.println(inFileName.getBytes(StandardCharsets.UTF_8).length);
        System.out.println(decodedFileName.getBytes(StandardCharsets.UTF_8).length);
    }
}

