/*
Класс Censor.
Создать статический метод public static void censorFile(String inoutFileName, String[] obscene), в котором прочитать
файл inoutFileName и заменить слова, содержащиеся в String[] obscene на '*', соответствующие количеству символов
в слове, изменения записать в исходный файл. В случае возникновения ошибки, выбросить свое собственное исключение
CensorException в котором сохранить - строку, полученную у оригинального exception через метод getMessage()
и имя файла, в котором возникла ошибка. В классе перекрыть метод toString(), вернув <имя файла>:<строка ошибки>.
Класс CensorException разместить в классе Censor

Например файл содержит:
Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
obscene = {"Java", "Oracle", "Sun", "Microsystems"}

Должен выдать результат:
**** — строго типизированный объектно-ориентированный язык программирования, разработанный компанией *** ************ (в последующем приобретённой компанией ******).
 */
package ru.progwards.java1.lessons.io2;

public class Censor {
    public static void censorFile(String inoutFileName, String[] obscene) {
    }

    public static void main(String[] args) {
        String[] obscene = {"Java", "Class", "Library", "Synchronized", "Accessor"};
        censorFile("hw_lesson11_task3", obscene);
    }
}
