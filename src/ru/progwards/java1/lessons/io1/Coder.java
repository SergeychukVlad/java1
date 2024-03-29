/*
Создать статический метод public static void codeFile(String inFileName, String outFileName, char[] code, String logName),
в котором прочитать файл inFileName и перекодировать его посимвольно в соответствии с заданным шифром,
результат записать в outFileName. Шифр задается маcсивом char[] code, где каждому символу symbol оригинального файла
соответствует символ code[(int)symbol] выходного файла.
В случае ошибок, в файл с именем logName вывести название ошибки через метод класса Exception - getMessage()
*/
package ru.progwards.java1.lessons.io1;

import java.io.*;

public class Coder {
    private static final String inFileName = "files/source.txt";          // исходный файл (цифры)- читаем ДЛЯ кодирования
    private static final String outFileName = "coded.txt";          // файл для хранения (буквы) - пишем ЗАКОДИРОВАННОЕ
    private static final String decodedFileName = "decoded.txt";    // файл ДЛЯ сохранения РАСКОДИРОВАННОГО (ждём цифры)
    private static final String logName = "log.txt";                // файл для хранения логов
    private static char[] mySecretCode = new char[256];             // массив символов (ключ - символ)
    private static int codeShift = 25;                              // ключ - смещение

    public static void main(String[] args) throws IOException {
        codeFile(inFileName, outFileName, getCode(), logName);
        decodeFile(outFileName, decodedFileName);
        System.setOut(System.out);
    }

    public static char[] getCode() {
        for (int i = 48; i < 58; i++) {
            mySecretCode[i] = (char) (i + codeShift);
        }
        return mySecretCode;
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        if (logName != null) {
            try {
                System.setOut(new PrintStream(new FileOutputStream(logName)));
            } catch (Exception e) {
                System.out.println("codeFile(). File logName " + e.getMessage());
            }
        }

        if (inFileName != null) {
            try {
                FileReader reader = new FileReader(inFileName);
                if (outFileName != null) {
                    try {
                        FileWriter writer = new FileWriter(outFileName);
                        try {
                            for (int symbol; (symbol = reader.read()) >= 0; ) {
                                writer.write(code[symbol]);
                            }
                        } catch (Exception e) {
                            System.out.println("codeFile(). Array code[] " + e.getMessage());
                        } finally {
                            reader.close();
                            writer.close();
                        }
                    } catch (Exception e) {
                        System.out.println("codeFile(). File outFileName: " + e.getMessage());
                    }
                }
            } catch (Exception e) {
                System.out.println("codeFile(). File inFileName: " + e.getMessage());
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
                } catch (Exception e) {
                    System.out.println("decodedFile(). File outFileName: " + e.getMessage());
                } finally {
                    reader.close();
                    writer.close();
                }
            } catch (Exception e) {
                System.out.println("decodedFile(). File decodedFileName: " + e.getMessage());
            }
        }
    }
}