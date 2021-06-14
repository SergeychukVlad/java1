package lesson11.part3.stringbuilder;
/*
StringBuilder. Некоторые операции со строками
 */
public class StringBuilderOperations {
    public static void main(String[] args) {
        //               0123456789
        String regNum = "а123аК 177";
        StringBuilder stringBuilder = new StringBuilder(regNum);
        stringBuilder.trimToSize();                                  // уменьшить буфер до размера данных
        System.out.println(stringBuilder.append("XXX"));              // добавить "ХХХ" в конец.     :  а123аК 177XXX
        System.out.println(stringBuilder.insert(4, "ZZZ")); // вставить "ZZZ" в позицию 4  :  а123ZZZаК 177XXX
        System.out.println(stringBuilder.reverse());                  // реверс строки               :  XXX771 КаZZZ321а
    }
}
