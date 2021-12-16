package lesson14.part2;

import java.util.ArrayDeque;

public class ArrayDequeAsStack {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("мороз");
        stack.push("и");
        stack.push("солнце");
        stack.push("день");
        stack.push("чудесный");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("LIFO в действии!");
    }
}

/*
Соответствие между  Queue   и   Deque
                    add()       addFirst()
throw Exception     element()   getFirst()
                    remove()    removeFirst()
---------------------------------------------
                    offer()     offerLast()
w/o Exception       peek()      peekFirst()
                    poll()      pollFirst()
=============================================

Методы интерфейса Deque для стека
                    push()      addFirst()
throw Exception     pop()       removeFirst()
                    peek()      peekFirst()
*/
