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
    public static String logMessage = "Нет файла с таким именем на устройстве!";

    public static void main(String[] args) throws IOException {
        char[] code = new char[65536];
        String inFileName, outFileName, logName;
        inFileName = "source1.txt";
        outFileName = "coded.txt";
        logName = "coder.log";

        codeFile(inFileName, outFileName, code, logName);
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

        if (inFileName != null) {
            try {
                FileReader fileReader = new FileReader(inFileName);
                try {
                    BufferedReader reader = new BufferedReader(fileReader);
                    for (int symbol; (symbol = reader.read()) >= 0; ) {
                        code[symbol] = (char) symbol;
                    }
                } finally {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println(logMessage);
                System.out.println(e.getMessage());
            }
        }

        if (outFileName != null) {
            try {
                FileWriter fileWriter = new FileWriter(outFileName);
                try {
                    fileWriter.write(code);
                } finally {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println(logMessage);
                System.out.println(e.getMessage());
            }
        }
    }
}

