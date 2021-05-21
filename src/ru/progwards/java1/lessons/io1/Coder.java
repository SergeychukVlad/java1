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

public class Coder {
    private static final String logMessage = "Нет файла с таким именем на устройстве!"; // многократное сообщение
    private static final String inFileName = "source.txt";                              // исходный файл (цифры)- читаем
    private static final String outFileName = "coded.txt";                              // здесь будут символы- пишем
    private static final String decodedFileName = "decoded.txt";                        // ждём исходный файл- читаем
    private static final String logName = "coder.log";                                  // файл для хранения логов
    private static char[] code = new char[256];                                         // исходный массив символов
    private static int codeShift = 25;                                                  // ключ-смещение

    public static void main(String[] args) throws IOException {
        codeFile(inFileName, outFileName, getCode(), logName);
        decodeFile(outFileName, decodedFileName);
        System.setOut(System.out);
    }

    public static char[] getCode() {
        for (int i = 48; i < 58; i++) {
            code[i] = (char) (i + codeShift);
        }
        return code;
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        if (logName != null) {
            try {
                System.setOut(new PrintStream(new FileOutputStream(logName)));
                System.out.println("Здесь будут логи для класса Coder");
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        if (outFileName != null) {
            try {
                FileWriter writer = new FileWriter(outFileName);
                if (inFileName != null) {
                    try {
                        FileReader reader = new FileReader(inFileName);
                        try {
                            for (int symbol; (symbol = reader.read()) >= 0; ) {
                                writer.write(code[symbol]);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            reader.close();
                            writer.close();
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void decodeFile(String outFileName, String decodedFileName) {
        if (decodedFileName != null) {
            try {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(outFileName));
                FileWriter writer = new FileWriter(decodedFileName);
                try {
                    for (int symbol; (symbol = reader.read()) >= 0; ) {
                        symbol = symbol - codeShift;
                        writer.write(symbol);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } finally {
                    reader.close();
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.print("символов: " + inFileName.getBytes(StandardCharsets.UTF_8).length + " vs ");
            System.out.print(decodedFileName.getBytes(StandardCharsets.UTF_8).length);
        }
    }
}