/*
Ключевую роль в TreeSet играет компаратор.
В данном случаем находится в классе-оболочке Integer.
compareTo(obj1, obj2) возвращает:
0 : когда объекты obj1 и obj2 равны
1 : когда obj1 > obj2
-1: когда obj1 < obj2
*/
package lesson13.part3;
import java.util.TreeSet;

public class TreeSetSimple {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(2);

        System.out.println(treeSet);
    }
}
