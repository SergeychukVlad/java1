/*
Резюме по лекции:
- В множестве TreeSet элементы сортируются автоматически
- Для TreeSet требуется Comparator:
    - либо реализованный интерфейс Comparable для элементов;
    - либо явно указанный в конструкторе (он будет приоритетным!)
- Для сравнения элементов на уникальность в TreeSet используется НЕ equals() как в HashSet или LinkedSet,
а compareTo() или compare().
- Интерфейс NavigableSet дополняет SortedSet оригинальными методами поиска в множестве, а также обратным итератором.
 */
package lesson13.part3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Answer_3 {

    public static void doTreeSet1() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(8);

        String s = "";
        Iterator<Integer> iterator = treeSet.descendingIterator();
        while (iterator.hasNext())
            s += iterator.next();
        System.out.println(s);
    }

    public static void doTreeSet2() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(19);
        treeSet.add(12);
        treeSet.add(15);
        treeSet.add(10);

        String s = "";
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
            s += iterator.next();
        System.out.println(s);
    }

    static class User {
        public Integer id;
        public String name;

        User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "{" + id + "," + name + '}';
        }
    }

    public static TreeSet<User> createSet() {
        return new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user2.id, user1.id);
            }
        });
    }

    public static TreeSet<User> createSetOnLambda() {
        return new TreeSet<>((user1, user2) -> Integer.compare(user2.id, user1.id));
    }

    public static void main(String[] args) {
        doTreeSet1();
        doTreeSet2();
        createSet();

    }
}
