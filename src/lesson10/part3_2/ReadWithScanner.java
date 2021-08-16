package lesson10.part3_2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadWithScanner {
    public static void readWithScannerAndSlashN() {
        try {
            Scanner scanner = new Scanner(new File("files/windows.txt"));
            FileWriter fileWriter = new FileWriter("out.txt");
            try {
                while (scanner.hasNextLine()) {
                    fileWriter.write(scanner.nextLine() + "\n");
                }
            } finally {
                try {
                    fileWriter.close();
                } catch (Throwable ignored) {
                }
                ;
                try {
                    scanner.close();
                } catch (Throwable ignored) {
                }
                ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readWithScannerAndLineSeparator() {
        try {
            Scanner scanner = new Scanner(new File("files/windows.txt"));
            FileWriter fileWriter = new FileWriter("out.txt");
            try {
                while (scanner.hasNextLine()) {
                    fileWriter.write(scanner.nextLine() + System.getProperty("line.separator"));
                }
            } finally {
                try {
                    fileWriter.close();
                } catch (Throwable ignored) {
                }
                ;
                try {
                    scanner.close();
                } catch (Throwable ignored) {
                }
                ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readWithFileReader() {
        /*
        FileReader - это класс для чтения символов из текстового файла.
        Позволяет читать символы по-одному или сразу массивом.
        Реализует интерфейс Closeable, поэтому может использоваться в try-with-resources
         */
        try {
            FileReader fileReader = new FileReader("files/windows.txt");
            FileWriter fileWriter = new FileWriter("out.txt");
            try {
                for (int ch; (ch = fileReader.read()) >= 0; ) {
                    fileWriter.write(ch);
                }
            } finally {
                try {
                    fileWriter.close();
                } catch (Throwable ignored) {
                }
                ;
                try {
                    fileReader.close();
                } catch (Throwable ignored) {
                }
                ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readWithFileReaderBuffered() {
        try {
            FileReader fileReader = new FileReader("files/windows.txt");
            FileWriter fileWriter = new FileWriter("out.txt");
            try {
                char[] buf = new char[5];
                for (int count; (count = fileReader.read(buf, 0, buf.length)) >= 0; ) {
                    fileWriter.write(buf, 0, count);
                }
            } finally {
                try {
                    fileWriter.close();
                } catch (Throwable ignored) {
                }
                ;
                try {
                    fileReader.close();
                } catch (Throwable ignored) {
                }
                ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int lineCount(String filename) throws IOException {
        int count = 0;
        try {
            FileReader fileReader = new FileReader(filename);
            try {
                for (int ch; (ch = fileReader.read()) >= 0; ) {
                    if (ch == 10) {
                        count++;
                    }
                }
            } finally {
                try {
                    fileReader.close();
                } catch (Exception e) {
                    throw new IOException("файл не найден");
                }
            }
        } catch (Exception e) {
            throw new IOException("файл не найден");
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
//        readWithScannerAndSlashN();
//        readWithScannerAndLineSeparator();
//        readWithFileReader();
//        readWithFileReaderBuffered();
        System.out.println(lineCount("out1.txt"));
    }
}