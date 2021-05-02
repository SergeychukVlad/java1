package lesson10.part3_1;

import java.io.FileWriter;
import java.io.IOException;

public class LogFileRewrite {
    // устойчивый (правильный) вариант организации записи в файл
    public static boolean log(String msg) {
        return log(msg, true);
    }

    public static boolean log(String msg, boolean toConsole) {
        if (toConsole) {
            System.out.println(msg);
        }
        try {
            // каждый раз создавать файл - перезаписывать!
            // FileWriter logFile = new FileWriter("logfile.txt");

            // а здесь - добавлять в конец файла
            FileWriter logFile = new FileWriter("logfile.txt", true);
            try {
                logFile.write(msg + "\n");
            } finally {
                logFile.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 55; i++) {
            log("Всё хорошо, процесс идёт по плану");
            log("Потоки символов сейчас залюьт экраны...");
            log("И всё это запишется в log-файл?");
            log("Это итерация " + i);
        }
    }
}
