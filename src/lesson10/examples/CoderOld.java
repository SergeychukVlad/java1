/*
Создать статичес. метод public static void codeFile(String inFileName, String outFileName, char[] code, String logName),
в котором прочитать файл inFileName и перекодировать его посимвольно в соответствии с заданным шифром,
результат записать в outFileName. Шифр задается маcсивом char[] code, где каждому символу symbol оригинального файла
соответствует символ code[(int)symbol] выходного файла.
В случае ошибок, в файл с именем logName вывести название ошибки через метод класса Exception - getMessage()
*/
package lesson10.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CoderOld {

    public static void main(String[] args) throws IOException {
        String sourceFileName = "source.txt";
        String codedFileName = "coded.txt";
        String logFileName = "log.txt";
        char[] code = {109, 121, 32, 115, 111, 117, 114, 99, 101, 32, 49, 32, 108, 105, 110, 101, 46};
        codeFile(sourceFileName, codedFileName, code, logFileName);
    }

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        char[] clone = code.clone();
        Arrays.sort(clone);
        int sizeCodedTable = clone[clone.length - 1] + 1;
        int[] toOutputFile = new int[sizeCodedTable];
        for (int i = 0; i < sizeCodedTable; i++) {
            toOutputFile[i] = i * i;
        }
        System.out.println(Arrays.toString(toOutputFile));

        char[] fromInputFile;
        char[] toCodedFile = new char[17];
        final int RADIX = 10;
        if (inFileName != null) {
            try {
                FileReader fileReader = new FileReader(inFileName);
                try {
                    String strFromFile;
                    Scanner scanner = new Scanner(fileReader);
                    while (scanner.hasNextLine()) {
                        strFromFile = scanner.nextLine();
                        fromInputFile = strFromFile.toCharArray();
                        System.out.println(fromInputFile.length);
                        for (int i = 0; i < fromInputFile.length; i++) {
                            if (fromInputFile[i] == code[i]) {
                                char ch = Character.forDigit(toOutputFile[code[i]], RADIX);
                                System.out.println(ch);
                                toCodedFile[i] = ch;
                            }
                        }
                    }
                } finally {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println("Нет файла с таким именем на устройстве!");
            }
        }

        if (outFileName != null) {
            try {
                FileWriter fileWriter = new FileWriter(outFileName);
                try {
                    fileWriter.write(String.valueOf(toCodedFile));
                } finally {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Нет файла с таким именем на устройстве!");
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
                    System.out.println((char) symbol + " соответствует " + symbol);
                    symbol = bufferedReader.read(); // Читаем символ
                    if (symbol == -1) {
                        break;
                    } else {
                        i++;
                        code[i] = (char) symbol;
                    }
                }
                char[] result = new char[i];
                for (int j = 0; j < i; j++) {
                    result[j] = code[j];
                }
                System.out.println(result.clone());
                return result;
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
