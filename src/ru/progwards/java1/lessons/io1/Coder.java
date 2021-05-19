/*
Создать статический метод public static void codeFile(String inFileName, String outFileName, char[] code, String logName),
в котором прочитать файл inFileName и перекодировать его посимвольно в соответствии с заданным шифром,
результат записать в outFileName. Шифр задается маcсивом char[] code, где каждому символу symbol оригинального файла
соответствует символ code[(int)symbol] выходного файла.
В случае ошибок, в файл с именем logName вывести название ошибки через метод класса Exception - getMessage()
*/
package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Coder {
    private static final String logMessage = "Нет файла с таким именем на устройстве!"; // многократное сообщение
    private static final String inFileName = "source.txt";                              // исходный файл - читаем
    private static final String outFileName = "coded.txt";                              // здесь будут символы - пишем
    private static final String logName = "coder.log";                                  // файл для хранения логов
    private static char[] code = new char[256];                                         //

    public static void main(String[] args) throws IOException {
        codeFile(inFileName, outFileName, getCode(), logName);
        System.setOut(System.out);
    }

    public static char[] getCode() {
        Arrays.fill(code, '*');
        for (int i = 48; i < 58; i++) {
            code[i] = (char) (i + 25);
            System.out.println(i + " " + code[i]);
        }
        return code;
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        if (logName != null) {
            try {
                System.setOut(new PrintStream(new FileOutputStream(logName)));
                System.out.println("Здесь будут логи для класса Coder\n");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
/*
Массив char:
везде звёздочки, кроме цифр. На месте цифр - буквы
  char[] code = new char[256];
    Arrays.fill(code, '*');

    for (int i = 48; i < 58; i++)
      code[i] = (char) (i + 16);
 */
        if (outFileName != null) {
            try {
                FileWriter writer = new FileWriter(outFileName);
                if (inFileName != null) {
                    try {
                        FileReader reader = new FileReader(inFileName);
                        try {
                            for (int symbol; (symbol = reader.read()) >= 0; ) {
                                code[symbol] = (char) symbol;
                                writer.write(code[symbol]);
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
                        writer.write(code[(scanner.nextInt())]);
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
            System.out.println(inFileName.getBytes(StandardCharsets.UTF_8).length);
            System.out.println(decodedFileName.getBytes(StandardCharsets.UTF_8).length);
        }
    }
}

