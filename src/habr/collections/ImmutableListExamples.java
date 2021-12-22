package habr.collections;

import java.util.ArrayList;
import java.util.List;

public class ImmutableListExamples {
    public static void main(String[] args) {
        List<Agent> agents = new ArrayList<>();
// компилируется, поскольку `List` расширяет `ImmutableList`
//        ImmutableList<Agent> section4 = agents;
// ничего не выводит
//        section4.forEach(System.out::println);

// теперь давайте изменим `section4`
//        agents.add(new Agent("Motoko");
// выводит "Motoko" – обождите, через какую дырку она сюда вкралась?!
//        section4.forEach(System.out::println);
    }
}
