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
        String sourceFileName, codedFileName, logFileName;
        sourceFileName = "source.txt";
        codedFileName = "coded.txt";
        logFileName = "coder.log";

        System.setOut(new PrintStream(new FileOutputStream(logFileName)));
        System.out.println("Redirect output stream.");

        char[] code = prepareCodeTable(sourceFileName);
        codeFile(sourceFileName, codedFileName, code, logFileName);
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        String toCodedFile = "";

        if (inFileName != null) {
            try {
                FileReader fileReader = new FileReader(inFileName);
                try {
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    int i = 0;
                    int symbol = bufferedReader.read();
                    while (symbol != -1) {
                        toCodedFile = toCodedFile + symbol;
                        i++;
                        symbol = bufferedReader.read();
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
                    fileWriter.write(toCodedFile);
                } finally {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println(logMessage);
                System.out.println(e.getMessage());
            }
            if (logName != null) {
                try {
                    FileWriter logWriter = new FileWriter(logName);
                    try {
                        logWriter.write(logName);
                    } finally {
                        logWriter.close();
                    }
                } catch (IOException l) {
                    System.out.println(logMessage);
                    System.out.println(l.getMessage());
                }
            }
        }
    }

    public static char[] prepareCodeTable(String sourceFile) {
        char[] code = new char[100];
        try {
            FileReader fileReader = new FileReader(sourceFile);
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                int symbol = bufferedReader.read();
                int i = 0;
                code[i] = (char) symbol;
                while (symbol != -1) {
                    code[i] = (char) symbol;
                    i++;
                    System.out.println((char) symbol + " соответствует " + symbol);
                    symbol = bufferedReader.read();
                }
                System.out.println(code);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                fileReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }
}

