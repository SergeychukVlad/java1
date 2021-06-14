package lesson11.part3.stringbuilder;
/*
Некоторые операции со строками
 */
public class StringOperations {
    public static void main(String[] args) {
        //               012345678901234567
        String regNum = "    а123аК 177    ";

        System.out.println(regNum.toUpperCase());
        System.out.println(regNum.toLowerCase());
        System.out.println(regNum.replace(" ", ""));
        System.out.println(regNum.trim());
        System.out.println(regNum.indexOf("123"));  // если подстрока не найдена, вернётся (-1)
        System.out.println(regNum.substring(5));
        System.out.println(regNum.substring(5, 8)); // 2-ой аргумент:индекс символа,до которого дойдем (не включая его!)
        System.out.println("Дополнительные функции работы со строками");
        System.out.println(regNum.contains("77"));
        System.out.println(regNum.contains("97"));
        System.out.println(regNum.isEmpty());       // общий вариант проверки
        System.out.println("".equals(regNum));      // чтобы не попасть на NPE
        System.out.println(regNum.isBlank());
    }
}
