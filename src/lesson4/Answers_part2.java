package lesson4;

import java.util.Arrays;
import java.util.List;

public class Answers_part2 {
    public static void main(String[] args) {
        checkConditions();
        List<Integer> grades = Arrays.asList(0, 60, 90, 101, -20);
        for (Integer grade : grades) {
            System.out.println(textGrade(grade));
        }
    }

    static void checkConditions() {
        System.out.println(3 - 1 > 2);
        System.out.println(5 >= 5);
        System.out.println(2 * 2 == 4);
        System.out.println(5 * 5 <= 25);
        System.out.println(7 * 7 == 47);
    }

    static String textGrade(int grade) {
        String result = "не определено";
        if (grade == 0) result = "не оценено";
        if (grade >= 1 && grade <= 20) result = "очень плохо";
        if (grade >= 21 && grade <= 40) result = "плохо";
        if (grade >= 41 && grade <= 60) result = "удовлетворительно";
        if (grade >= 61 && grade <= 80) result = "хорошо";
        if (grade >= 81 && grade <= 100) result = "отлично";
        return result;
    }
}
