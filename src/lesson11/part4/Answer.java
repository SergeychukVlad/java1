/*
Часть 1. Правильные ответы:
RandomAccessFile позволяет перемещаться по файлу побайтно в разные стороны с указанием позиции,
RandomAccessFile позволяет читать, записывать (и перезаписывать) данные в текущую позицию,
RandomAccessFile умеет читать и записывать строки

Часть 2. Правильный ответ:
Прочитать строку                                                → String readLine(),
Записать что-то побайтно                                        → void write…(...),
Переместить курсор к позиции                                    → void seek(long pos),
Прочитать массив байт в буфер bytes                             → int read(byte[] bytes),
Считывает и возвращает байт (беззнаковое значение)              → int read(),
Считывает требуемое количество байт и возвращает указанный тип  → read…(),
Возвращает текущую позицию курсора                              → long getFilePointer()

Задание к части 3.
Реализовать метод с сигнатурой public String setStars(String filename) который читает файл filename
и меняет в нем каждый 10-йбайт на символ *, при этом конкатенируя оригинальный символ в строку ответа.
В случае ошибки выбросить исключение IOException со строкой сообщения: равной имени класса оригинального сообщения

Например,при содержимом файла:
0123456789012345678A012345678B01
новое содержимое должно быть
012345678*012345678*012345678*01
и метод должен вернуть "9AB"
 */
package lesson11.part4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Answer {
    /*
    0123456789012345678A012345678B01
    */
    public static String setStars(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        int offset = 10;

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw")) {
            if (randomAccessFile.length() < offset) {
//            ничего не выводить в этом блоке! только пустую строку. Иначе - ошибка!
                return "";
            } else {
                for (int i = 1; i <= 3; i++) {
                    randomAccessFile.seek(offset * i - 1);
                    stringBuilder.append(randomAccessFile.readLine().charAt(0));
                    randomAccessFile.seek(offset * i - 1);
                    randomAccessFile.writeBytes("*");
                }
            }
        } catch (FileNotFoundException e) {
//            ничего не выводить в этом блоке! Иначе - ошибка!
        } catch (IOException e) {
            System.out.println(e.getClass());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(setStars("foranswerok"));
        System.out.println(setStars("ttt"));
        System.out.println(setStars("forerror"));
    }
}